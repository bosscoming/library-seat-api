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
                        @RequestParam(value = "sid") Integer s_id) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Reader reader = readerService.loginByPwd(id, pwd, s_id);
            System.out.println("reader" + reader);
            if(reader != null){
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(reader);
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
