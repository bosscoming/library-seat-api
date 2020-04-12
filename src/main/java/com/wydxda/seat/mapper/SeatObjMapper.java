package com.wydxda.seat.mapper;

import com.wydxda.seat.model.SeatObj;
import com.wydxda.seat.model.SeatTemplete;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SeatObjMapper {
    void insertSeat(@Param("seatList") List<SeatObj> seatObjList, @Param("seatTemplete") SeatTemplete seatTemplete);

    void deleteByIdList(@Param("idList")List<Integer> idList);

    List<SeatObj> findByTempleteId(@Param("templeteId")Integer templeteId);
}