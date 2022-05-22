package com.qjj.service.impl;
import com.qjj.dao.InfoDao;
import com.qjj.model.entity.EditUserInfo;
import com.qjj.model.entity.EditUserInfoByID;
import com.qjj.model.entity.UserInfoShow;
import com.qjj.model.entity.UserPermission;
import com.qjj.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public List<UserInfoShow> getInfoByID(int user_id){
        return infoDao.getInfoByID(user_id);
    }

    @Override
    public int getPointsByID(int user_id){
        return infoDao.getPointsByID(user_id);
    }

    @Override
    public int updateUserInfo(EditUserInfoByID editUserInfoByID){
        return infoDao.updateUserInfo(editUserInfoByID);
    }

    @Override
    public List<UserPermission> getUserPermission(){
        return infoDao.getUserPermission();
    }
}
