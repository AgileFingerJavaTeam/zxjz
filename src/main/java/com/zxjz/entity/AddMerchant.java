package com.zxjz.entity;

public class AddMerchant {
    private String registrationTime;
    private String boundPhone;
    private int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getBoundPhone() {
        return boundPhone;
    }

    public void setBoundPhone(String boundPhone) {
        this.boundPhone = boundPhone;
    }
}
