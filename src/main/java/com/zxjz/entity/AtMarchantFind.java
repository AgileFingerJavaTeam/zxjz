package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class AtMarchantFind {

      private int userId;
      private String merchantsName;
      private String head;
      private String boundPhone;
      private String registrationTime;
      private String state;
      private String isLook;
      private String merchantsState;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBoundPhone() {
        return boundPhone;
    }

    public void setBoundPhone(String boundPhone) {
        this.boundPhone = boundPhone;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsLook() {
        return isLook;
    }

    public void setIsLook(String isLook) {
        this.isLook = isLook;
    }

    public String getMerchantsState() {
        return merchantsState;
    }

    public void setMerchantsState(String merchantsState) {
        this.merchantsState = merchantsState;
    }

    @Override
    public String toString() {
        return "AtMarchantFind{" +
                "userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                ", head='" + head + '\'' +
                ", boundPhone='" + boundPhone + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", state='" + state + '\'' +
                ", isLook='" + isLook + '\'' +
                ", merchantsState='" + merchantsState + '\'' +
                '}';
    }
}
