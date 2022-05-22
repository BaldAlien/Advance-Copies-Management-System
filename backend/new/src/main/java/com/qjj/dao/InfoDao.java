package com.qjj.dao;

import com.qjj.model.entity.*;

import java.util.List;

public interface InfoDao {
    List<UserInfoShow> getInfoByID(int user_id);
    int getPointsByID(int user_id);
    int updateUserInfo(EditUserInfoByID editUserInfoByID);
    List<UserPermission> getUserPermission();
}
