package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoShow {
    private Integer userId;
    private String userName;
    private String email;
    private String consignee;
    private String phoneNum;
    private String address;
    private String certify;
}