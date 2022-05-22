package com.qjj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qjj.model.entity.Products;
import com.qjj.model.param.ProductsQueryParam;
import com.qjj.model.vo.ProductsVO;
import com.qjj.DTO.PageDTO;
import com.qjj.utils.PageVO;

import java.io.Serializable;
import java.util.Collection;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
public interface ProductsService extends IService<Products> {

    /**
     * 创建或修改【请填写功能名称】
     *
     * @param products 【请填写功能名称】
     */
    void saveProducts(Products products);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】id
     */
    void deleteProducts(Serializable id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param idList 【请填写功能名称】id列表
     */
    void deleteProducts(Collection<? extends Serializable> idList);

    /**
     * 通过id查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】id
     * @return 【请填写功能名称】
     */
     Products getProducts(Serializable id);

    /**
     * 分页查询【请填写功能名称】
     *
     * @param pageDTO 分页数据
     * @param param   查询条件
     * @return PageVO
     */
     PageVO<ProductsVO> getProductsList(PageDTO pageDTO, ProductsQueryParam param);
}
