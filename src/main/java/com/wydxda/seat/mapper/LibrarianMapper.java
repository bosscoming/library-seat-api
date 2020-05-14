package com.wydxda.seat.mapper;

import com.wydxda.seat.model.Librarian;
import org.apache.ibatis.annotations.Param;

public interface LibrarianMapper {
    Librarian loginByPwd(@Param("id")Integer id, @Param("pwd")String pwd, @Param("s_id")Integer school_id);
    Librarian findByOpenid(@Param("openid")String openid);
    boolean updateLibrarianInfo(@Param("openid")String openid,@Param("id")Integer id,@Param("url")String url,@Param("nickname")String nickname);

    boolean updateLibrarianOpenid(@Param("openid")String openid,@Param("id") Integer id);

    void logoutLibrarianOpenid(@Param("openid")String openid);

    Librarian findByPwd(@Param("id") String id, @Param("pwd") String pwd);
}
