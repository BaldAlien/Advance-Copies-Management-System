package com.qjj.service.impl;
import com.qjj.dao.PointsDao;
import com.qjj.model.entity.Points;
import com.qjj.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsServiceImpl implements PointsService{

    @Autowired
    private PointsDao pointsDao;

    @Override
    public int checkPointByID(int user_id){
        return pointsDao.checkPointByID(user_id);
    }


    @Override
    public int updatePointsById(Points points){
        return pointsDao.updatePointsById(points);
    }

    @Override
    public int checkUser(int user_id){
        return pointsDao.checkUser(user_id);
    }

    @Override
    public int initPoints(int user_id){
        return pointsDao.initPoints(user_id);
    }
}
