package com.qjj.controller;

import com.qjj.DTO.PageDTO;
import com.qjj.annotation.ResponseConversion;
import com.qjj.model.vo.ProductsVO;
import com.qjj.model.entity.Products;
import com.qjj.model.param.ProductsQueryParam;
import com.qjj.model.vo.ProductsVO;
import com.qjj.service.ProductsService;
//import com.qjj.anno.ResponseResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.qjj.DTO.PageDTO;
import com.qjj.utils.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collection;

/**
 * 【请填写功能名称】Controller
 * 
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
@Slf4j
@Api(tags = "【请填写功能名称】管理接口")
@RestController
@ResponseBody
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    /**
     * 创建或修改【请填写功能名称】
     *
     * @param products 【请填写功能名称】
     */
    @ApiOperation("创建或修改【请填写功能名称】")
    @PostMapping("/save")
    @ResponseConversion
    public void saveProducts(@Valid @RequestBody Products products) {
        productsService.saveProducts(products);
    }

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】id
     */
    @ApiOperation("删除【请填写功能名称】")
    @PostMapping("/delete")
    @ResponseConversion
    public void deleteProducts(@ApiParam(value = "【请填写功能名称】id", required = true) @RequestParam("id") Serializable id) {
        productsService.deleteProducts(id);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param idList 【请填写功能名称】id列表
     */
    @ApiOperation(value = "批量删除【请填写功能名称】")
    @PostMapping("/delete/batch")
    @ResponseConversion
    public void deleteProducts(@RequestBody Collection<? extends Serializable> idList) {
        productsService.deleteProducts(idList);
    }

    /**
     * 通过id查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】id
     * @return 【请填写功能名称】
     */
    @ApiOperation("通过id查询【请填写功能名称】")
    @GetMapping("/{id}")
    @ResponseBody
    public Products getProducts(@PathVariable("id") Serializable id) {
        return productsService.getProducts(id);
    }

    /**
     * 分页查询【请填写功能名称】
     *
     * @param pageDTO 分页数据
     * @param param   查询条件
     * @return PageVO
     */
    @ApiOperation(value = "分页查询【请填写功能名称】信息")
    @GetMapping("/list")
    public PageVO<ProductsVO> getProductsList(PageDTO pageDTO, ProductsQueryParam param) {
        log.info("{}",pageDTO);
        return productsService.getProductsList(pageDTO, param);
    }
}
