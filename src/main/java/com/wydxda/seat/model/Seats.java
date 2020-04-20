package com.wydxda.seat.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Seats {
    private List<SeatObj> seats;
    private Integer templeteName;
    private Integer templeteId;
    private Integer templeteRoom_num;
}