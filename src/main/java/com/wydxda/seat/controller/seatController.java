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
}
