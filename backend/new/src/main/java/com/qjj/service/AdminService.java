package com.qjj.service;

import com.qjj.model.entity.EditProducts;

public interface AdminService {
    int editProducts(EditProducts editProducts);

    int deleteProduct(int id);
}
