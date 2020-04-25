package com.wydxda.seat.services;

import com.wydxda.seat.mapper.HistoryMapper;
import com.wydxda.seat.model.History;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Transactional
    public List<History> findByOpenidList(String openid){
        return historyMapper.findByOpenidList(openid);
    }
}
