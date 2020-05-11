package com.wydxda.seat.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeatsResponseBean {
    private Integer errCode;
    private String errMsg;
    private Integer roomNum;
    private String schoolName;
    private String schoolUrl;
    private String campuses;
    private String uType;
    private List<SeatObj> seatList;

    private List<SeatType> seatTypeList;
}
