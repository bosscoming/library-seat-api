package com.wydxda.seat.mapper;


import com.wydxda.seat.model.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HistoryMapper {
    void insertHistory(
            @Param("openid") String openid,
            @Param("seatId") Integer seatId,
            @Param("type") String type,
            @Param("minute") Integer minute
    );

    List<History> findByOpenidList(@Param("openid") String openid);
}