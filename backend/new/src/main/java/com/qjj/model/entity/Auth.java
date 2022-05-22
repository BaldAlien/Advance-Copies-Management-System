package com.qjj.model.entity;
import java.io.Serializable;

public class Auth implements Serializable
{
    private int user_id;
    private String username;
    private String password;
    private Integer permission;

    public Auth(int id, String username, String password, Integer permission) {
        this.user_id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public Auth() {}

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
