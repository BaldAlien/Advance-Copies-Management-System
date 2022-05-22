package com.qjj.controller;


import com.qjj.constant.Constant;
import com.qjj.model.entity.EditProducts;
import com.qjj.model.entity.History;
import com.qjj.model.entity.Response;
import com.qjj.service.AdminService;
import com.qjj.service.HistoryService;
import com.qjj.utils.JWTUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "历史样书申请记录接口")
@Slf4j
@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @ResponseBody
    @RequestMapping(path="/getAll" , method = {RequestMethod.GET})
    public Object getAllHistory() {
        Response res = new Response();
        try {
            List<History> historyList = historyService.getAllHistory();
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "获取全部申请历史成功");
            res.data.put("historyList",historyList);
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_FAILED;
            res.data.put("message", "获取全部申请历史失败");
        }
        return res;
    }


    @ResponseBody
    @RequestMapping(path="/getHistory" , method = {RequestMethod.GET})
    public Object getHistory(@RequestHeader("token") String token) {
        Response res = new Response();
        int user_id = JWTUtils.getUserId(token);
        try {
            List<History> historyList = historyService.getHistoryByID(user_id);
            res.code = Constant.CODE_SUCCESS;
            res.data.put("message", "获取该用户申请历史成功");
            res.data.put("historyList",historyList);
        }catch (Exception e) {
            e.printStackTrace();
            res.code = Constant.CODE_FAILED;
            res.data.put("message", "获取该用户申请历史失败");
        }
        return res;
    }

}
