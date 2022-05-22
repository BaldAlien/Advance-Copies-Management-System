package com.qjj.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qjj.constant.Constant;
import com.qjj.model.entity.*;
import com.qjj.service.AdminService;
import com.qjj.service.InfoService;
import com.qjj.service.ProductsService;
import com.qjj.utils.JWTUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "管理端接口")
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private InfoService infoService;

    @RequestMapping(path="/edit" , method = {RequestMethod.POST})
    public Object listTypeGrade(@RequestBody EditProducts obj) {
        Response res = new Response();
        try {
            adminService.editProducts(obj);
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "编辑产品成功");
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_UPDATE_SHOPPING_CART;
            res.data.put("message", "编辑产品失败");
        }
        return res;
    }

    @RequestMapping(path="/delete" , method = {RequestMethod.POST})
    public Object deleteProduct(@RequestBody DeleteId id) {
        Response res = new Response();
        try {
            adminService.deleteProduct(id.getId());
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "删除产品成功");
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_UPDATE_SHOPPING_CART;
            res.data.put("message", "删除产品失败");
        }
        return res;
    }

    @RequestMapping(path="/userPermission" , method = {RequestMethod.GET})
    public Object getUserPermission() {
        Response res = new Response();
        try {
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "获取普通用户账号信息成功");
            res.data.put("userList", infoService.getUserPermission());
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_UPDATE_SHOPPING_CART;
            res.data.put("message", "获取普通用户账号信息失败");
        }
        return res;
    }


}
