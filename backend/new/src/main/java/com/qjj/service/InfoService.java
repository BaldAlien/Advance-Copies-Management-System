package com.qjj.service;


import com.qjj.model.entity.EditUserInfo;
import com.qjj.model.entity.EditUserInfoByID;
import com.qjj.model.entity.UserInfoShow;
import com.qjj.model.entity.UserPermission;

import java.util.List;

public interface InfoService {
    List<UserInfoShow> getInfoByID(int user_id);
    int getPointsByID(int user_id);
    int updateUserInfo(EditUserInfoByID editUserInfoByID);
    List<UserPermission>getUserPermission();
}
