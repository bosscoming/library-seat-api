package com.wydxda.seat.services;

import com.wydxda.seat.mapper.LibrarianMapper;
import com.wydxda.seat.model.Librarian;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class LibrarianService {

    @Autowired
    private LibrarianMapper librarianMapper;

    @Transactional
    public Librarian loginByPwd(Integer id, String pwd, Integer school_id){
        return librarianMapper.loginByPwd(id,pwd,school_id);
    }

    @Transactional
    public Librarian findByOpenid(String openid){
        return librarianMapper.findByOpenid(openid);
    }

    @Transactional
    public boolean updateLibrarianInfo(String openid,Integer id,String url,String nickname){
        return librarianMapper.updateLibrarianInfo(openid,id,url,nickname);
    }

    @Transactional
    public boolean updateLibrarianOpenid(String openid,Integer id){
        return librarianMapper.updateLibrarianOpenid(openid,id);
    }
}
