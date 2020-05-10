package com.wydxda.seat.controller;

import com.wydxda.seat.model.*;
import com.wydxda.seat.services.ReaderService;
import com.wydxda.seat.services.SeatService;
import com.wydxda.seat.services.SeatTempleteService;
import com.wydxda.seat.services.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class seatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private ReaderService readerService;
    @Autowired
    private SeatTypeService seatTypeService;
    @Autowired
    private SeatTempleteService seatTempleteService;

    @RequestMapping(value = "/seatList", method = RequestMethod.POST)
    @ResponseBody
    public Object findSeatListByTempleteId(
            @RequestParam(value = "id") Integer templeteId,
            @RequestParam(value = "openid") String openid
            ) {
        try {
            Reader reader = readerService.findByOpenid(openid);
            if(reader == null) {
                ResponseBean responseBean = new ResponseBean();
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("请先绑定学校账号后重试");
                return responseBean;
            }
            SeatsResponseBean seatsResponseBean = new SeatsResponseBean();
            Seats seats = seatService.findSeatListByTempleteId(templeteId);
            seatsResponseBean.setErrCode(0);
            seatsResponseBean.setErrMsg("success");
            seatsResponseBean.setCampuses(reader.getSchool().getCampuses());
            seatsResponseBean.setSchoolName(reader.getSchool().getSchoolName()+"图书馆");
            seatsResponseBean.setSchoolUrl(reader.getSchool().getUrl());
            seatsResponseBean.setRoomNum(seats.getTempleteRoomNum());
            seatsResponseBean.setSeatList(seats.getSeats());
            List<SeatType> seatTypeList = seatTypeService.findAll();
            seatsResponseBean.setSeatTypeList(seatTypeList);
            return seatsResponseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("fail");
            return responseBean;
        }
    }

    @RequestMapping(value = "/roomNumList", method = RequestMethod.GET)
    @ResponseBody
    public Object findTempleteIdList(@RequestParam(value = "openid") String openid) {
        try {

            Reader reader = readerService.findByOpenid(openid);
            if(reader == null) {
                ResponseBean responseBean = new ResponseBean();
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("请先绑定学校账号后重试");
                return responseBean;
            }
            List<SeatTemplete> list = seatTempleteService.findByTempleteIdList(reader.getSchool().getId());
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("success");
            responseBean.setData(list);
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            e.printStackTrace();
            return responseBean;
        }
    }

    @RequestMapping(value = "/getNowSeatInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getNowSeatInfo(
            @RequestParam(value = "seatId") Integer id,
            @RequestParam(value = "openid") String openid
            ){
        //TODO 管理员用户身份 openid 验证
        return seatService.getNowSeatInfo(id);
    }

    @RequestMapping(value = "/reportSeat",method = RequestMethod.GET)
    public Object reportSeat(
            @RequestParam(value = "openid") String openid,
            @RequestParam(value = "code") String code
    ){

        ResponseBean responseBean = new ResponseBean();
        Reader reader = readerService.findByOpenid(openid);
        if(reader == null) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("请先绑定学校账号后重试");
            return responseBean;
        }
        Integer id = Integer.parseInt(code);
        // 先判断座位使用情况 如果有人使用中，无法抢占
        SeatObj seatIsUse = seatService.checkSeatNowCanUse(id);
        if(seatIsUse == null){
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("当前座位有人正在使用中");
            return responseBean;
        }
        String type = "5";
        try{
            seatService.updateSeatType(id,type);
            responseBean.setData(0);
            responseBean.setErrMsg("success");
        }catch (Exception e){
            responseBean.setErrMsg("fail");
            responseBean.setErrCode(-1);
        }
        return responseBean;
    }
}
