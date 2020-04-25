package com.wydxda.seat.mapper;

import com.wydxda.seat.model.SeatNow;
import com.wydxda.seat.model.SeatObj;
import com.wydxda.seat.model.SeatTemplete;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SeatObjMapper {
    void insertSeat(@Param("seatList") List<SeatObj> seatObjList, @Param("seatTemplete") SeatTemplete seatTemplete);

    void deleteByIdList(@Param("idList") List<Integer> idList);

    List<SeatObj> findByTempleteId(@Param("templeteId") Integer templeteId);

    SeatObj findById(@Param("id") Integer id);

    void updateSeatsType(@Param("templeteId") Integer templeteId);

    void updateSeat(
            @Param("openid") String openid,
            @Param("id") Integer id,
            @Param("type") String type,
            @Param("duration") Integer duration
    );

    SeatNow getNowSeatInfo(@Param("id") Integer id);

    void updateNowSeatType(@Param("id") Integer id);

    SeatObj checkSeatNowCanUse(@Param("id") Integer id);
}