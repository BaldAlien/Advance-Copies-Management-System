package com.qjj.dao;


import com.qjj.model.entity.User;
import com.qjj.model.entity.UserInfo;

import java.util.Map;

public interface AuthDao {

    String findById(String username);

    int getPermissionByUsername(String username);

    int registerUser(User user);

    int findIdByName(String username);

    int setUserInfo(UserInfo userInfo);

    Map<String,String> getPasswordAndSaltByUsername(String username);
}
