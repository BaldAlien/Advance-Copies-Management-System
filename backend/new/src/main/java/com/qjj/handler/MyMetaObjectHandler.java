package com.qjj.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mybatisplus 自动注入
 * @author zjw
 * @package drug
 * @Date 2022/3/11
 * @Time 23:31
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
         this.strictInsertFill(metaObject, "delFlag", String.class,"0");
//        this.strictInsertFill(metaObject, "addTime", Date::new, Date.class);
//        log.info("-----------------------------------");
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
