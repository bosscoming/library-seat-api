package com.wydxda.seat.controller;

import com.wydxda.seat.model.Librarian;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.services.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class librarianController {

    @Autowired
    private LibrarianService librarianService;

    @RequestMapping(value = "/librarianLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam(value = "uid") Integer id,
                        @RequestParam(value = "pwd") String pwd,
                        @RequestParam(value = "sid") Integer s_id,
                        @RequestParam(value = "openid") String openid) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Librarian librarian = librarianService.loginByPwd(id, pwd, s_id);
            if(librarian != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(librarian);
                librarianService.updateLibrarianOpenid(openid,id);
            }else {
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("fail");
                responseBean.setData(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            responseBean.setData(false);
        }
        return responseBean;
    }

    @RequestMapping(value = "/findLibrarianByOpenid", method = RequestMethod.GET)
    @ResponseBody
    public Object findByOpenid(@RequestParam(value = "openid")String openid){
        ResponseBean responseBean = new ResponseBean();
        try {
            Librarian librarian = librarianService.findByOpenid(openid);
            if(librarian != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(librarian);
            }else {
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("fail");
            }
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
        }
        return responseBean;
    }

    @RequestMapping(value = "/findLibrarianByPwd", method = RequestMethod.GET)
    @ResponseBody
    public Object findByPwd(
            @RequestParam(value = "username") String id,
            @RequestParam(value = "password") String pwd){
        ResponseBean responseBean = new ResponseBean();
        try {
            Librarian librarian = librarianService.findByPwd(id,pwd);
            if(librarian != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(librarian);
            }else {
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("用户名密码错误");
            }
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("服务器忙...");
        }
        return responseBean;
    }

    @RequestMapping(value = "/updateLibrarianInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateLibrarianInfo(
            @RequestParam(value = "openid")String openid,
            @RequestParam(value = "uid")Integer uid,
            @RequestParam(value = "url")String url,
            @RequestParam(value = "nickname")String nickname
    ){
        ResponseBean responseBean = new ResponseBean();
        try {
            boolean isOk = librarianService.updateLibrarianInfo(openid, uid, url, nickname);
            if(isOk){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(true);
            }else {
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("fail");
                responseBean.setData(false);
            }
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            responseBean.setData(false);
        }
        return responseBean;
    }

}
