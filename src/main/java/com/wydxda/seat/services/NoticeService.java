package com.wydxda.seat.services;

import com.wydxda.seat.mapper.NoticeMapper;
import com.wydxda.seat.model.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Transactional
    public List<Notice> findByOpenIdList(String openid) {
        return noticeMapper.findByOpenIdList(openid);
    }

    @Transactional
    public List<Notice> findByLibrarianOpenIdList(String openid) {
        return noticeMapper.findByLibrarianOpenIdList(openid);
    }

    @Transactional
    public Notice findById(Integer id) {
        return noticeMapper.findById(id);
    }

    public void insertNotice(String imgUrl, String title, String content, Integer school_id, Integer librarian_id) {
        noticeMapper.insertNotice(imgUrl,title,content,school_id,librarian_id);
    }
}
