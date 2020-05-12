package com.wydxda.seat.mapper;

import com.wydxda.seat.model.Reader;
import org.apache.ibatis.annotations.Param;

public interface ReaderMapper {
    Reader loginByPwd(@Param("id")Integer id, @Param("pwd")String pwd, @Param("s_id")Integer school_id);
    Reader findByOpenid(@Param("openid")String openid);
    boolean updateReaderInfo(@Param("openid")String openid,@Param("id")Integer id,@Param("url")String url,@Param("nickname")String nickname);

    boolean updateReaderOpenid(@Param("openid")String openid,@Param("id") Integer id);
    boolean logoutReaderOpenid(@Param("openid")String openid);
}
