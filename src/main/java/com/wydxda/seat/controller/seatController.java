package com.wydxda.seat.controller;

import com.wydxda.seat.model.*;
import com.wydxda.seat.services.ReaderService;
import com.wydxda.seat.services.SeatService;
import com.wydxda.seat.services.SeatTempleteService;
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

    @RequestMapping(value = "/findSeatListById", method = RequestMethod.POST)
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
            return seatsResponseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("fail");
            return responseBean;
        }
    }
}
