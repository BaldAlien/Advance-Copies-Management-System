package com.qjj.dao;

import com.qjj.model.entity.EditProducts;

public interface AdminDao {
    int editProducts(EditProducts editProducts);
    int deleteProduct(int id);
}
