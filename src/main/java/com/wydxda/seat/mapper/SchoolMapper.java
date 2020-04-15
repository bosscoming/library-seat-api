package com.wydxda.seat.mapper;

import com.wydxda.seat.model.School;
import com.wydxda.seat.model.SeatObj;
import com.wydxda.seat.model.SeatTemplete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchoolMapper {
    List<School> getSchoolList();
}