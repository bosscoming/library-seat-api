package com.wydxda.seat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reader {
    private Integer id;
    private String openid;
    private String url;
    private String name;
    private String nickname;
    private String sex;

    private Integer s_id;
//    一对一
    private School school;

    private String department;
    private String professional;
    private String class_name;
    private Integer grade;
    private Integer status;
}
