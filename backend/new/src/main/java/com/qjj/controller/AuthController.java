package com.qjj.controller;


import com.alibaba.fastjson.JSONObject;
import com.qjj.annotation.ResponseConversion;
import com.qjj.constant.Constant;
import com.qjj.constant.MessageConstant;
import com.qjj.model.entity.*;
import com.qjj.service.AuthService;
import com.qjj.service.PointsService;
import com.qjj.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("/auth")
@Api(tags = "登录接口")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private PointsService pointsService;

    @PostMapping("/login")
    public Object login(@RequestBody Login jsonObj) {
        Response res = new Response();
        HashMap<String, String> payload = new HashMap<>();

        String username = jsonObj.getUsername();
        String password = jsonObj.getPassword();


        Map<String,String> PasswordAndSalt = authService.getPasswordAndSaltByUsername(username);
        if (PasswordAndSalt == null) {   //   判断是否为空
        //      登录失败
            res.code = Constant.CODE_LOGIN_FAILED;
            res.data.put("message", MessageConstant.LOGIN_FAILURE);
            return res;
        }

        String passwordWithSalt = PasswordAndSalt.get("password");  //获取用户对应密码密文
        String salt  = PasswordAndSalt.get("salt");                 //获取盐值

        //判断用户输入的加密后密码是否与数据库中存储的密文匹配
        if (passwordWithSalt.equals(DigestUtils.md5DigestAsHex((password + salt).getBytes()))){
            int byPermission = authService.getPermissionByUsername(username);

            int idByName = authService.findIdByName(username);
            payload.put("user_id", String.valueOf(authService.findIdByName(username)));
            String token = JWTUtils.getToken(payload);

            res.data.put("token", token);   //返回令牌
            res.data.put("permission", byPermission);
            res.data.put("message", MessageConstant.LOGIN_SUCCESS);
        //      登录成功
            res.code = Constant.CODE_SUCCESS;
            return res;
        }
        res.data.put("message", MessageConstant.LOGIN_FAILURE);
        //      登录失败
        res.code = Constant.CODE_LOGIN_FAILED;
        return res;
    }




    @PostMapping("/register")
    @ResponseBody
    public Object register(@RequestBody RegisterForm jsonObj) {
        Response res = new Response();
        HashMap<String, String> payload = new HashMap<>();
        //      读取注册名字（不能同名）
        String username = jsonObj.getUsername();

        String byId = authService.findById(username);

        if (authService.findById(username) != null) {
            res.code = Constant.CODE_REGISTER_USERNAME_DUPLICATE;
            res.data.put("message", MessageConstant.REUSE_NAME);
            return res;
        }
        //    获取注册密码
        String password = jsonObj.getPassword();
        //    生成随机数来获取盐
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        String salt = sb.toString();
        //    加盐
        String passwordWithSalt = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        User user = new User( username, passwordWithSalt, Constant.DOMESTIC_USER, salt);
        //    注册到user表
        if (1 != authService.registerUser(user)) {
            res.code = Constant.CODE_REGISTER_DATABASE_OP_FAILED;
            res.data.put("message", MessageConstant.REGISTER_FAILURE);
            return res;
        }
        int idByName = authService.findIdByName(username);
        //    初始化账号教师身份认证信息
        String certify="未认证";
        //    判断是否插入成功
        if (authService.setUserInfo(new UserInfo(idByName,certify )) < 0) {
            res.code = Constant.CODE_REGISTER_DATABASE_OP_FAILED;
            res.data.put("message", MessageConstant.REGISTER_FAILURE);
            return res;
        }
        //    初始化账号持有积分
        int user_id = authService.findIdByName(username);
        pointsService.initPoints(user_id);

        res.code = Constant.CODE_SUCCESS;
        res.data.put("message", MessageConstant.REGISTER_SUCCESS);
        return res;
    }
}
