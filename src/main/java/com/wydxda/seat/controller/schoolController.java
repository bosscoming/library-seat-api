package com.wydxda.seat.controller;

import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.model.School;
import com.wydxda.seat.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class schoolController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/schoolList", method = RequestMethod.GET)
    @ResponseBody
    public Object getSchoolList() {
        try {
            List<School> schoolList = schoolService.getSchoolList();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("成功");
            responseBean.setData(schoolList);
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("失败");
            return responseBean;
        }
    }
}
