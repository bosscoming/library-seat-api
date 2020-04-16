package com.wydxda.seat.services;

import com.wydxda.seat.mapper.ReaderMapper;
import com.wydxda.seat.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Transactional
    public Reader loginByPwd(Integer id, String pwd, Integer school_id){
        return readerMapper.loginByPwd(id,pwd,school_id);
    }
}
