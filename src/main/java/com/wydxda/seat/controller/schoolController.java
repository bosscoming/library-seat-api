package com.wydxda.seat.controller;

import com.wydxda.seat.model.Notice;
import com.wydxda.seat.model.Reader;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.model.School;
import com.wydxda.seat.services.NoticeService;
import com.wydxda.seat.services.ReaderService;
import com.wydxda.seat.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class schoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ReaderService readerService;

    @RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    @ResponseBody
    public Object getSchoolList() {
        try {
            List<School> schoolList = schoolService.getSchoolList();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("success");
            responseBean.setData(schoolList);
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            return responseBean;
        }
    }

    @RequestMapping(value = "/noticeList", method = RequestMethod.GET)
    @ResponseBody
    public Object findBySchoolIdList(
            @RequestParam(value = "openid") String openid
    ) {
        ResponseBean responseBean = new ResponseBean();
        try {
            List<Notice> noticeList = noticeService.findByOpenIdList(openid);
            if (noticeList != null) {
                responseBean.setErrCode(0);
                responseBean.setErrMsg("success");
                responseBean.setData(noticeList);
            }
            return responseBean;
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            return responseBean;
        }
    }

    @RequestMapping(value = "/getNotice", method = RequestMethod.GET)
    @ResponseBody
    public Object findById(
            @RequestParam(value = "openid") String openid,
            @RequestParam(value = "id") Integer noticeId
    ) {
        ResponseBean responseBean = new ResponseBean();
        try {
            Reader reader = readerService.findByOpenid(openid);
            if(reader != null){
                Notice notice = noticeService.findById(noticeId);
                if (notice != null) {
                    responseBean.setErrCode(0);
                    responseBean.setErrMsg("success");
                    responseBean.setData(notice);
                }
                return responseBean;
            }
            else {
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("User does not exist");
                return responseBean;
            }
        } catch (Exception e) {
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            return responseBean;
        }
    }


}
