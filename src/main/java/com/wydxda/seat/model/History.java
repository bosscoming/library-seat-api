package com.wydxda.seat.model;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class History {
    private Integer id;
    private String openid;
    private Integer seatId;

    //    一对一
    private SeatObj seatObj;

    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date startTime;
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date endTime;
    private String type;
}
