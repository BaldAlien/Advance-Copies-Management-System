package com.qjj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qjj.dao.typeDao;
import com.qjj.model.entity.type;
import com.qjj.service.typeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class typeServiceImpl extends ServiceImpl<typeDao, type> implements typeService {

    @Autowired
    private typeDao typeDao;

    @Override
    public List<type> getAll() {
        QueryWrapper<type> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type","教育用书");
//        type one = getOne(queryWrapper);
//        log.info("{}",one);
        return typeDao.selectList(queryWrapper);
    }
}
