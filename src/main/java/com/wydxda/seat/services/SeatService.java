package com.wydxda.seat.services;

import com.wydxda.seat.mapper.SeatObjMapper;
import com.wydxda.seat.mapper.SeatTempleteMapper;
import com.wydxda.seat.model.SeatNow;
import com.wydxda.seat.model.SeatObj;
import com.wydxda.seat.model.SeatTemplete;
import com.wydxda.seat.model.Seats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SeatService {

    @Autowired
    private SeatObjMapper seatObjMapper;
    @Autowired
    private SeatTempleteMapper seatTempleteMapper;

    @Transactional
    public void insertSeatAndReplace(List<SeatObj> seatObjList, SeatTemplete seatTemplete) {
        if (seatTemplete.getId() != null) {
            List<SeatObj> existList = seatObjMapper.findByTempleteId(seatTemplete.getId());
            List<Integer> idList = existList.stream().map(SeatObj::getId).collect(Collectors.toList());
            if (idList.size() > 0) {
                seatObjMapper.deleteByIdList(idList);
            }
        }
        seatTempleteMapper.insertTemplete(seatTemplete);
        seatObjMapper.insertSeat(seatObjList, seatTemplete);
    }

    @Transactional
    public Seats findSeatListByTempleteId(Integer id) {
        Seats seats = new Seats();
        seatObjMapper.updateSeatsType(id);//更新座位状态类型
        List<SeatObj> existList = seatObjMapper.findByTempleteId(id);
        SeatTemplete seatTemplete = seatTempleteMapper.findTempleteById(id);
        seats.setSeats(existList);
        seats.setTempleteId(seatTemplete.getId());
        seats.setTempleteFloorNum(seatTemplete.getFloorNum());
        seats.setTempleteRoomNum(seatTemplete.getRoomNum());
        return seats;
    }

    @Transactional
    public void updateSeatsType(Integer templeteId) {
        seatObjMapper.updateSeatsType(templeteId);
    }

    @Transactional
    public void updateNowSeatType(Integer id) {
        seatObjMapper.updateNowSeatType(id);
    }


    @Transactional
    public SeatObj findById(Integer id) {
        return seatObjMapper.findById(id);
    }

    @Transactional
    public void updateSeat(
            String openid,
            Integer id,
            String type,
            Integer duration
    ) {
        seatObjMapper.updateSeat(openid, id, type, duration);
    }

    @Transactional
    public void updateSeatType(
            Integer id,
            String type
    ) {
        seatObjMapper.updateSeatType(id, type);
    }

    @Transactional
    public SeatNow getNowSeatInfo(Integer id) {
        return seatObjMapper.getNowSeatInfo(id);
    }

    @Transactional
    public SeatObj checkSeatNowCanUse(Integer id){
        return seatObjMapper.checkSeatNowCanUse(id);
    }
}
