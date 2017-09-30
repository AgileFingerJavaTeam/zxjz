package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class MerchantStatusTwo {
        private int userId;
        private int recruitId;
        private int collegeUserId;
        private String name;
        private String sex;
        private String numberJob;
        private String phoneInfoUrl;
        private double finalPay;
        private String postName;
        private String afterConfirmation;
        private String studentsConfirmed;
        private String businessHireTime;

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

    public String getAfterConfirmation() {
        return afterConfirmation;
    }

    public void setAfterConfirmation(String afterConfirmation) {
        this.afterConfirmation = afterConfirmation;
    }

    public String getStudentsConfirmed() {
        return studentsConfirmed;
    }

    public void setStudentsConfirmed(String studentsConfirmed) {
        this.studentsConfirmed = studentsConfirmed;
    }

    public String getBusinessHireTime() {
        return businessHireTime;
    }

    public void setBusinessHireTime(String businessHireTime) {
        this.businessHireTime = businessHireTime;
    }

    @Override
    public String toString() {
        return "MerchantStatusTwo{" +
                "userId=" + userId +
                ", recruitId=" + recruitId +
                ", collegeUserId=" + collegeUserId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", numberJob='" + numberJob + '\'' +
                ", phoneInfoUrl='" + phoneInfoUrl + '\'' +
                ", finalPay=" + finalPay +
                ", postName='" + postName + '\'' +
                ", afterConfirmation='" + afterConfirmation + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", businessHireTime='" + businessHireTime + '\'' +
                '}';
    }
}
