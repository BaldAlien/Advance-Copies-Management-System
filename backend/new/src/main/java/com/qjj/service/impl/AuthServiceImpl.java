package com.qjj.service.impl;


import com.qjj.dao.AuthDao;
import com.qjj.model.entity.User;
import com.qjj.model.entity.UserInfo;
import com.qjj.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;


    @Override
    public String findById(String username) {

        return authDao.findById(username);
    }


    @Override
    public int getPermissionByUsername(String username) {

        return authDao.getPermissionByUsername(username);
    }

    @Override
    public int registerUser(User user) {

        return authDao.registerUser(user);
    }

    @Override
    public int findIdByName(String username) {

        return authDao.findIdByName(username);
    }

    @Override
    public int setUserInfo(UserInfo userInfo) {

        return authDao.setUserInfo(userInfo);
    }

    @Override
    public Map<String, String> getPasswordAndSaltByUsername(String username) {
        return authDao.getPasswordAndSaltByUsername(username);
    }

}
