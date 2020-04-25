package com.wydxda.seat.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SeatObj {
    private Integer id;

    private Integer x;

    private Integer y;

    private String row;

    private String col;

    private Integer roomNum;

    private String type;

    private Integer flag = 0;

    private String templeteId;

    //    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    //TODO 时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date updateTime;
}