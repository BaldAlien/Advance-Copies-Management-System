package com.qjj.dao;

import com.qjj.model.entity.Points;

public interface PointsDao {
    //通过user_id查找剩余积分
    int checkPointByID(int user_id);

    //更新积分
    int updatePointsById(Points points);

    //检查用户是否有账号
    int checkUser(int user_id);

    //注册初始化积分
    int initPoints(int user_id);
}
