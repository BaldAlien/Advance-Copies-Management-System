package com.qjj.service.impl;
import com.qjj.dao.AdminDao;
import com.qjj.model.entity.EditProducts;
import com.qjj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public int editProducts(EditProducts editProducts){
        return adminDao.editProducts(editProducts);
    }

    @Override
    public int deleteProduct(int id){
        return adminDao.deleteProduct(id);
    }
}
