package com.qjj.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.diboot.core.binding.Binder;
import com.diboot.core.util.BeanUtils;
import com.qjj.DTO.PageDTO;
import com.qjj.exception.BaseException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public final class PageConverterKt<T> {


    public static <T> Page<T> toPage(PageDTO pageDTO){
        Page<T> page = new Page<>(pageDTO.getPageNumber(),pageDTO.getPageSize());
        return page;
    }

    public static <P,V> V ObjectVO(Object o,Class<V> target){
        V newV;
        try {
            newV = target.newInstance();
            BeanUtil.copyProperties(o,newV);
            log.info("{}",newV);
            Binder.bindRelations(newV);
        } catch (Exception e) {
            e.printStackTrace();
           throw new BaseException("创建V失败");
        }
        return newV;
    }

    public static <P,V> PageVO<V> toVO(IPage<P> pageInfopo, Class<V> v) {
        try{
            PageVO<V> vo = new PageVO<>();
            // 创建Page对象，实际上是一个ArrayList类型的集合
            if (pageInfopo != null){
                List<P> records = pageInfopo.getRecords();
                ArrayList<V> list = new ArrayList<>();
                for (P record: records ) {
                    if (record != null){
                        V newV = v.newInstance();
                        //把原对象数据拷贝到新的对象
                        BeanUtil.copyProperties(record,newV);
                        list.add(newV);
                    }
                }
                Binder.bindRelations(list);
                vo.setRecords(list);
                vo.setTotal(Long.valueOf(list.size()));
                return vo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <P,V> IPage<V> pageVoCovert(IPage<P> pageInfopo, Class<V> v) {
        try{

            PageVO<P> vo = new PageVO<>();

            // 创建Page对象，实际上是一个ArrayList类型的集合
            if (pageInfopo != null){
                IPage<V> page = new Page(pageInfopo.getCurrent(), pageInfopo.getSize());
                page.setTotal(pageInfopo.getTotal());
                List<P> records = pageInfopo.getRecords();
                ArrayList<V> list = new ArrayList<>();

                for (P record: records ) {
                    if (record != null){
                        V newV = v.newInstance();
                        //把原对象数据拷贝到新的对象
                        BeanUtil.copyProperties(record,newV);
                        list.add(newV);
                    }
                }
                page.setRecords(list);
                page.setTotal(pageInfopo.getTotal());
                return page;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
