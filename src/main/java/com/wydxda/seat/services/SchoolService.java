package com.wydxda.seat.services;

import com.wydxda.seat.mapper.SchoolMapper;
import com.wydxda.seat.model.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Transactional
    public List<School> getSchoolList() {
        return schoolMapper.getSchoolList();
    }
}
