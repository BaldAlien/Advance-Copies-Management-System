package com.qjj.service.impl;

import com.qjj.dao.TrolleyDao;
import com.qjj.model.entity.Trolley;
import com.qjj.model.entity.TrolleyShow;
import com.qjj.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrolleyServiceImpl implements TrolleyService {

    @Autowired
    private TrolleyDao trolleyDao;

    @Override
    public int addCart(Trolley trolley) {
        return trolleyDao.addCart(trolley);
    }

    @Override
    public int subCart(Trolley trolley) {
        return trolleyDao.subCart(trolley);
    }

    @Override
    public int insertCart(Trolley trolley) {
        return trolleyDao.insertCart(trolley);
    }

    @Override
    public Trolley findById(int user_id) {
        return null;
    }


    @Override
    public Trolley checkCart(Trolley trolley) {
        return trolleyDao.checkCart(trolley);
    }

    @Override
    public int checkProductNum(int product_id) {
        return trolleyDao.checkProductNum(product_id);
    }

    @Override
    public int purchase(Trolley trolley) {
        return trolleyDao.purchase(trolley);
    }

    @Override
    public int updateProduct(Trolley trolley) {
        return trolleyDao.updateProduct(trolley);
    }

    @Override
    public int deleteProduct(Trolley trolley) {
        return trolleyDao.deleteProduct(trolley);
    }


    @Override
    public int deleteProductsByUserId(int user_id) {
        return trolleyDao.deleteProductsByUserId(user_id);
    }

    @Override
    public List<TrolleyShow> entry(int user_id) {
        return trolleyDao.entry(user_id);
    }

    @Override
    public int checkPoints(int user_id){return trolleyDao.checkPoints(user_id);}

}
