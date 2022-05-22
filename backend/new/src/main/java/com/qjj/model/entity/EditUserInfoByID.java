package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditUserInfoByID {
    private int user_id;
    private String email;
    private String consignee;
    private String phone_num;
    private String address;
}