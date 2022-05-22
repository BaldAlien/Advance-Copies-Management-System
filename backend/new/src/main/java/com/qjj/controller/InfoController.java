package com.qjj.controller;


import com.qjj.constant.Constant;
import com.qjj.model.entity.EditUserInfo;
import com.qjj.model.entity.EditUserInfoByID;
import com.qjj.model.entity.Response;
import com.qjj.model.entity.UserInfoShow;
import com.qjj.service.InfoService;
import com.qjj.utils.JWTUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户信息接口")
@Slf4j
@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService InfoService;

    @ResponseBody
    @RequestMapping(path="/getInfoByID" , method = {RequestMethod.GET})
    public Object getInfoByID(@RequestHeader("token") String token) {
        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        try {
            List<UserInfoShow> infoList = InfoService.getInfoByID(user_id);
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "获取该用户信息成功");
            res.data.put("infoList",infoList);
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_FAILED;
            res.data.put("message", "获取该用户信息失败");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(path="/getPointsByID" , method = {RequestMethod.GET})
    public Object getPoints(@RequestHeader("token") String token) {
        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        try {
            int points = InfoService.getPointsByID(user_id);
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "获取该用户积分成功");
            res.data.put("points",points);
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_FAILED;
            res.data.put("message", "获取该用户积分失败");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(path="/updateInfoByID" , method = {RequestMethod.POST})
    public Object updateUserInfo(@RequestHeader("token") String token ,@RequestBody EditUserInfo jsonObj) {
        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        try {
            EditUserInfoByID form = new EditUserInfoByID(user_id, jsonObj.getEmail(), jsonObj.getConsignee(), jsonObj.getPhone_num(), jsonObj.getAddress());
            int points = InfoService.updateUserInfo(form);
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "更改用户信息成功");
            res.data.put("points",points);
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_FAILED;
            res.data.put("message", "更改用户信息失败");
        }
        return res;
    }
}
