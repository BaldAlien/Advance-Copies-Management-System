package com.qjj.service.impl;


import com.qjj.dao.GradeDao;
import com.qjj.model.entity.Grade2;
import com.qjj.model.entity.Grade3;
import com.qjj.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;


    @Override
    public List<String> listTypeGrade(String type) {
        return gradeDao.listTypeGrade(type);
    }
    @Override
    public  List<String> listG1(String type){
        return gradeDao.listG1(type);
    }
    @Override
    public  List<String> listG2(Grade2 grade2){
        return gradeDao.listG2(grade2);
    }

    @Override
    public  List<String> listG3(Grade3 grade3){
        return gradeDao.listG3(grade3);
    }
}
