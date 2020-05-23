package com.wydxda.seat.controller;

import com.wydxda.seat.model.Librarian;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.services.LibrarianService;
import com.wydxda.seat.services.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class noticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private LibrarianService librarianService;

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    @ResponseBody
    public Object insertNotice(
            @RequestParam("openid") String openid,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Librarian librarian = librarianService.findByOpenid(openid);
            if(librarian == null){
                responseBean.setErrMsg("请登录后重试");
                responseBean.setErrCode(1);
            }else {
                Integer school_id = librarian.getS_id();
                Integer librarian_id = librarian.getId();
//            TODO imgUrl 前端未传
                String imgUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/qTPPIKRc7QpSNDfXHYqkBYfmsdUU0493v4MrySrzYFMjsHQQw8CcBuEFVddtvofbn8pyZLmDGesLZAGu3xL6jA/0?wx_fmt=jpeg";
                noticeService.insertNotice(imgUrl,title,content,school_id,librarian_id);
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("fail");
        }
        return responseBean;
    }
}
