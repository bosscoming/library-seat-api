package com.wydxda.seat.controller;

import com.wydxda.seat.model.Reader;
import com.wydxda.seat.model.ResponseBean;
import com.wydxda.seat.model.SeatObj;
import com.wydxda.seat.services.HistoryService;
import com.wydxda.seat.services.ReaderService;
import com.wydxda.seat.services.SeatService;
import com.wydxda.seat.utils.DistanceUtils;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class readerController {

    @Autowired
    private ReaderService readerService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private HistoryService historyService;

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
            @RequestParam(value = "nickname")String nickname
    ){
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

    @RequestMapping(value = "/checkScanCode",method = RequestMethod.POST)
    @ResponseBody
    public Object checkScanCode(
            @RequestParam(value = "openid")String openid,
            @RequestParam(value = "latitude")Double latitude,
            @RequestParam(value = "longitude")Double longitude,
            @RequestParam(value = "code")String code,
            @RequestParam(value = "type")String type,
            @RequestParam(value = "duration")Integer duration //分钟
    ){
        ResponseBean responseBean = new ResponseBean();
        Integer id = 0;
        try{
            // 验证用户身份
            Reader reader = readerService.findByOpenid(openid);
            if(reader == null){
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("该用户不存在");
                return responseBean;
            }

            // 验证 座位编码
            System.out.println(code);
            id = Integer.parseInt(code);//TODO 暂时code 为 ls_seats id
            SeatObj seat = seatService.findById(id);
            if(seat == null){
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("该座位不存在");
                return responseBean;
            }

            //验证 位置范围
            Double schLatitude = reader.getSchool().getLatitude();
            Double schLongitude = reader.getSchool().getLongitude();
            boolean isOk = DistanceUtils.allowedDistance(schLatitude,schLongitude,latitude,longitude);
            if(!isOk){
                responseBean.setErrCode(-1);
                responseBean.setErrMsg("请在图书馆位置范围重试");
                return responseBean;
            }
            seatService.updateSeat(openid,id,type,duration);
        }catch (Exception e){
            responseBean.setErrCode(-1);
            responseBean.setErrMsg("fail");
            e.printStackTrace();
            return responseBean;
        }
        // TODO 添加读者用户学习记录
        historyService.insertHistory(openid,id,type,duration);
        responseBean.setErrCode(0);
        responseBean.setErrMsg("success");
        return responseBean;
    }
}
