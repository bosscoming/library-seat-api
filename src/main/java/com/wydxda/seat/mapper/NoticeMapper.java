package com.wydxda.seat.mapper;


import com.wydxda.seat.model.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NoticeMapper {
    List<Notice> findByOpenIdList(@Param("openid") String openid);
    Notice findById(@Param("id") Integer id);
}