package com.qjj.service.impl;
//
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diboot.core.entity.BaseEntity;
import com.qjj.DTO.PageDTO;
import com.qjj.dao.ProductsDao;
import com.qjj.utils.PageConverterKt;
import com.qjj.utils.PageVO;
import com.qjj.utils.QueryBuilder;

import com.qjj.model.entity.Products;
import com.qjj.model.param.ProductsQueryParam;
import com.qjj.model.vo.ProductsVO;
import com.qjj.service.ProductsService;
//import com.qjj.model.entity.BaseEntity;
import com.qjj.utils.K;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, Products> implements ProductsService {

    @Override
    public void saveProducts(Products products) {
        K.isFalseThrow(saveOrUpdate(products)).message("提交【请填写功能名称】失败");
    }

    @Override
    public void deleteProducts(Serializable id) {
        //QueryWrapper<Products> wrapper = new QueryWrapper<>();
       // removeById()
          K.isFalseThrow(removeById(id)).message("删除【请填写功能名称】失败");
    }

    @Override
    public void deleteProducts(Collection<? extends Serializable> idList) {
        K.isTrueThrow(K.isNullOrEmpty(idList)).message("尚未选择【请填写功能名称】，无法删除");
        K.isFalseThrow(removeByIds(idList)).message("删除【请填写功能名称】失败");
    }

    @Override
    public Products getProducts(Serializable id) {
        return getById(id);
    }

    @Override
    public PageVO<ProductsVO> getProductsList(PageDTO pageDTO, ProductsQueryParam param) {
        Page<Products> page = PageConverterKt.toPage(pageDTO);
        final LambdaQueryWrapper<Products> wrapper = QueryBuilder.toLambdaQueryWrapper(param);
         wrapper.orderByAsc(Products::getBookId);//这句是根据条件排序的
         page(page, wrapper); //这句执行分页
        return PageConverterKt.toVO(page, ProductsVO.class);
    }

}
