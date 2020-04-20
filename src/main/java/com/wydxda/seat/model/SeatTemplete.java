package com.wydxda.seat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SeatTemplete {
    private Integer id;

    private Integer floor_num;

    private Integer flag;

    private Boolean status;

    private Integer room_num;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    private Date updateTime;
}