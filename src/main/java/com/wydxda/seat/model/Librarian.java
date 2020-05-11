package com.wydxda.seat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Librarian {
    private Integer id;
    private String openid;
    private Integer sId;

    private Integer s_id;
    private School school;

    private String name;
    private String nickname;
    private String url;
    private String sex;
}
