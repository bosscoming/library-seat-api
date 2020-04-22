package com.wydxda.seat.services;
import com.wydxda.seat.mapper.SeatTempleteMapper;
import com.wydxda.seat.model.SeatTemplete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class SeatTempleteService {

    @Autowired
    private SeatTempleteMapper seatTempleteMapper;
    @Transactional
    public List<SeatTemplete> findByTempleteList() {
        return seatTempleteMapper.findByTempleteList();
    }
    @Transactional
    public void deleteTemplete(List<Integer> idList) {
         seatTempleteMapper.deleteTemplete(idList);
    }

    public List<SeatTemplete> findByTempleteIdList(Integer sid) {
        return seatTempleteMapper.findByTempleteIdList(sid);
    }
}
