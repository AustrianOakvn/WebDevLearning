package com.mpec.javaweb.model;

import java.util.Properties;

public class UserModel {

    private String userName;
    private String fullName;


    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
