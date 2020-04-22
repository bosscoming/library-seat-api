package com.wydxda.seat.services;

import com.wydxda.seat.mapper.SeatTypeMapper;
import com.wydxda.seat.model.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SeatTypeService {

    @Autowired
    private SeatTypeMapper seatTypeMapper;

    @Transactional
    public List<SeatType> findAll() {
        return seatTypeMapper.findAll();
    }
}
