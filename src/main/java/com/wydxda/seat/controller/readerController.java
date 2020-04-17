package com.wydxda.seat.controller;

import com.wydxda.seat.model.Reader;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class readerController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(value = "/readerLogin", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam(value = "uid") Integer id,
                        @RequestParam(value = "pwd") String pwd,
                        @RequestParam(value = "sid") Integer s_id,
                        @RequestParam(value = "openid") String openid) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Reader reader = readerService.loginByPwd(id, pwd, s_id);
            if(reader != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(reader);
                readerService.updateReaderOpenid(openid,id);
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

    @RequestMapping(value = "/findReaderByOpenid", method = RequestMethod.GET)
    @ResponseBody
    public Object findByOpenid(@RequestParam(value = "openid")String openid){
        ResponseBean responseBean = new ResponseBean();
        try {
            Reader reader = readerService.findByOpenid(openid);
            if(reader != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(reader);
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

    @RequestMapping(value = "/updateReaderInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReaderInfo(
            @RequestParam(value = "openid")String openid,
            @RequestParam(value = "uid")Integer uid,
            @RequestParam(value = "url")String url,
            @RequestParam(value = "nickname")String nickname){
        ResponseBean responseBean = new ResponseBean();
        try {
            boolean isOk = readerService.updateReaderInfo(openid, uid, url, nickname);
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
