package com.qjj.constant;

public interface Constant {
    int ADMIN = 0;      //管理员
    int DOMESTIC_USER = 9;      //普通用户权限

    int CODE_SUCCESS = 0;       //成功返回0
    int CODE_FAILED = 1;       //失败返回1
    int CODE_VERIFICATION_FAILED = 2;     //token校验失败
    int CODE_MISSING_TOKEN = 3;     //缺少token
    int CODE_LOGIN_FAILED = 4;      //登录失败,用户名和密码不符
    int CODE_REGISTER_USERNAME_DUPLICATE = 5;      //用户名重复
    int CODE_REGISTER_DATABASE_OP_FAILED = 6;      //注册失败，数据库操作错误
    int CODE_UPDATE_SHOPPING_CART = 7;      //更新购物车失败，数据库操作错误
}
