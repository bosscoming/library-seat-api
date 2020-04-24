package com.wydxda.seat.mapper;


import org.apache.ibatis.annotations.Param;


public interface HistoryMapper {
    void insertHistory(
            @Param("openid") String openid,
            @Param("seatId") Integer seatId,
            @Param("type") String type,
            @Param("minute") Integer minute
    );

}