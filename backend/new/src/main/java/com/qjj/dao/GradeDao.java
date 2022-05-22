package com.qjj.dao;


import com.qjj.model.entity.Grade2;
import com.qjj.model.entity.Grade3;

import java.util.List;


public interface GradeDao {

    List<String> listTypeGrade(String type);
    List<String> listG1(String type);
    List<String> listG2(Grade2 grade2);
    List<String> listG3(Grade3 grade3);

}
