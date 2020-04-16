package com.wydxda.seat.mapper;

import com.wydxda.seat.model.Reader;
import org.apache.ibatis.annotations.Param;

public interface ReaderMapper {
    Reader loginByPwd(@Param("id")Integer id, @Param("pwd")String pwd, @Param("s_id")Integer school_id);
}
