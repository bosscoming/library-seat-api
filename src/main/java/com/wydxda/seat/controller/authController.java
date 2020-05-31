package com.wydxda.seat.controller;

import com.alibaba.fastjson.JSONObject;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.services.LibrarianService;
import com.wydxda.seat.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class authController {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private LibrarianService librarianService;
    @RequestMapping(value = "/code2Session", method = RequestMethod.GET)
    @ResponseBody
    public Object jsCode2Session(@RequestParam(value = "code") String code) {
        ResponseBean responseBean = new ResponseBean();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.weixin.qq.com/sns/jscode2session" +
                    "?appid=" + "wxb42b37d94ce17c22" +
                    "&secret=" + "cbf7bcda32ab450c881ff95d65a76b5a" +
                    "&grant_type=authorization_code" +
                    "&js_code=" + code;
            String forObject = restTemplate.getForObject(url, String.class);
            JSONObject json = JSONObject.parseObject(forObject);
            Integer errcode = (Integer) json.get("errcode");
            if (errcode == null || errcode == 0) {
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(json.get("openid"));
            } else {
                responseBean.setErrCode(0);
                responseBean.setErrMsg((String) json.get("errmsg"));
                return responseBean;
            }
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            responseBean.setData("");
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout(@RequestParam(value = "openid") String openid) {
        ResponseBean responseBean = new ResponseBean();
        try {
            librarianService.logoutLibrarianOpenid(openid);
            readerService.logoutReaderOpenid(openid);
        } catch (Exception e) {

        }
        return responseBean;
    }
}
