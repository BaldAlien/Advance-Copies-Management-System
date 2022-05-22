package com.qjj.controller;


import com.qjj.model.entity.type;
import com.qjj.service.typeService;
import com.qjj.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "typejiekou")
@RestController
@RequestMapping("/type")
public class typeDaoController {

    @Autowired
    private typeService service;

    @GetMapping("/list")
    @ApiOperation("getAllType")
    public ResultBean getAllType(){
       return ResultBean.success(service.getAll());
    }
}
