package com.wydxda.seat.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Notice {
    private Integer id;
    private String imgUrl;
    private String title;
    private String content;

    //一对一
    private Librarian librarian;
    private Integer schoolId;

    private School school;

    private Integer librarianId;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private Integer num;
}
