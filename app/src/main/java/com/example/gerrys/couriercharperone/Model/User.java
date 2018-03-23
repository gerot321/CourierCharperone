package com.example.gerrys.couriercharperone.Model;

/**
 * Created by Cj_2 on 2017-11-03.
 */

public class User {
    private String name;
    private String password;
    private String phone;
    private String status;
    private String base;

    public User(){
    }

    public User(String name, String password,String status,String base) {
        this.name = name;
        this.password = password;
        this.status = status;
        this.base=base;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserStatus() {
        return status;
    }

    public void setUserStatus(String status) {
        this.status = status;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
