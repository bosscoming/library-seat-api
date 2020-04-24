package com.wydxda.seat.services;

import com.wydxda.seat.mapper.HistoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Transactional
    public void insertHistory( String openid,
                              Integer seatId,
                              String type,
                              Integer minute){
        historyMapper.insertHistory(openid,seatId,type,minute);
    }
}
