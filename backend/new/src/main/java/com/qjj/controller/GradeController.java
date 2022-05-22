package com.qjj.controller;
import com.qjj.model.entity.Grade2;
import com.alibaba.fastjson.JSONObject;
import com.qjj.model.entity.Grade3;
import com.qjj.model.entity.History;
import com.qjj.model.entity.Response;
import  com.qjj.constant.Constant;
import com.qjj.service.GradeService;
import com.qjj.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/listTG")
    @ResponseBody
    public Object listTypeGrade(String type){   //用户传入参数：一级分类
        List<Object> list = new ArrayList<>();
        Response res = new Response();
        List<String> g1=gradeService.listG1(type);  //查询该一级分类下的所有二级分类
        for(int i=0;i<g1.size();i++){
            List<Object> val1List = new ArrayList<>();
            HashMap<String, Object> val1 = new HashMap<>();
            Grade2 grade2 = new Grade2(type,(String) g1.get(i));
            List<String> g2=gradeService.listG2(grade2);    //查询某二级分类下的所有三级分类
            for(int j=0;j<g2.size();j++){
                HashMap<String, Object> val2 = new HashMap<>();
                Grade3 grade3 = new Grade3(type,(String) g1.get(i),(String) g2.get(j));
                val2.put((String) g2.get(j),gradeService.listG3(grade3));    //查询某三级分类下的所有四级分类
                val1List.add(val2);
            }
            val1.put((String) g1.get(i),val1List);
            list.add(val1);
        }

        res.code = Constant.CODE_SUCCESS;
        res.data.put("message","已返回对应TG信息");
        res.data.put("list",list);
        return res;
    }
    

}
