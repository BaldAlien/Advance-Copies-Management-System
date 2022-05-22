package com.qjj.service;

import com.qjj.model.entity.Trolley;
import com.qjj.model.entity.TrolleyShow;

import java.util.ArrayList;
import java.util.List;

public interface TrolleyService {

    //添加商品(已存在)
    int addCart(Trolley trolley);

    //删减商品(已存在)
    int subCart(Trolley trolley);

    //添加商品（不存在）
    int insertCart(Trolley trolley);

    //查找是否用户购物车存在对应商品
    Trolley findById(int user_id);

    //查找是否用户购物车存在对应商品
    Trolley checkCart(Trolley trolley);

    //用户购买时检查产品数量
    int checkProductNum(int book_id);

    //购买对应商品
    int purchase(Trolley trolley);

    //更新商品
    int updateProduct(Trolley trolley);

    //删除商品
    int deleteProduct(Trolley trolley);

    //根据用户ID删除所有商品
    int deleteProductsByUserId(int user_id);

//    向前端提供用户购物车情况
    List<TrolleyShow> entry(int user_id);

    int checkPoints(int user_id);
}
