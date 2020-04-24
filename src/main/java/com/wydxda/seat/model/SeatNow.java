package com.wydxda.seat.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
@Getter
@Setter
public class SeatNow {
    private Integer id;

    private String type;

    private Integer uId;

    private String url;

    private String name;
    private String nickname;
    private String sex;
    private String department;
    private String professional;
    private String className;
    private Integer grade;
    //剩余时间
    private Time remainderTime;


}
