package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class MerchantStatusOne {
            private int userId;
            private int recruitId;
            private int collegeUserId;
            private String contact;
            private String name;
            private String sex;
            private String numberJob;
            private String phoneInfoUrl;
            private double finalPay;
            private String postName;
            private String registrationTime;
            private String hired;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public int getCollegeUserId() {
        return collegeUserId;
    }

    public void setCollegeUserId(int collegeUserId) {
        this.collegeUserId = collegeUserId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumberJob() {
        return numberJob;
    }

    public void setNumberJob(String numberJob) {
        this.numberJob = numberJob;
    }

    public String getPhoneInfoUrl() {
        return phoneInfoUrl;
    }

    public void setPhoneInfoUrl(String phoneInfoUrl) {
        this.phoneInfoUrl = phoneInfoUrl;
    }

    public double getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    @Override
    public String toString() {
        return "MerchantStatusOne{" +
                "userId=" + userId +
                ", recruitId=" + recruitId +
                ", collegeUserId=" + collegeUserId +
                ", contact='" + contact + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", numberJob='" + numberJob + '\'' +
                ", phoneInfoUrl='" + phoneInfoUrl + '\'' +
                ", finalPay=" + finalPay +
                ", postName='" + postName + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", hired='" + hired + '\'' +
                '}';
    }
}
