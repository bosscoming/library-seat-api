package com.wydxda.seat.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class History {
    private Integer id;
//    private String openid;
    private Integer seatId;

    //    一对一
//    private SeatObj seatObj;

    @JSONField(format="yyyy-MM-dd ")//数据库导出页面时json格式化
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date endTime;

    private String typeName;
}
