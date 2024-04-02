package com.retail.retail.domain;


import com.retail.retail.service.UserType;

public class User {
    UserType userType;
    String userName;

    public User(String userName, UserType type){
        this.userName = userName;
        this.userType = type;
    }

    public UserType getUserType(){
        return this.userType;
    }

    public String getUserName(){
        return this.userName;
    }
}
