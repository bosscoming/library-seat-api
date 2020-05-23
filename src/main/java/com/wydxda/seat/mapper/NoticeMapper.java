package com.wydxda.seat.mapper;


import com.wydxda.seat.model.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NoticeMapper {
    List<Notice> findByOpenIdList(@Param("openid") String openid);
    List<Notice> findByLibrarianOpenIdList(@Param("openid") String openid);
    Notice findById(@Param("id") Integer id);

    void insertNotice(
            @Param("imgUrl") String imgUrl,
            @Param("title") String title,
            @Param("content") String content,
            @Param("school_id") Integer schoolId,
            @Param("librarian_id") Integer librarianId);
}