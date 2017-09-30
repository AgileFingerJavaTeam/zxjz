package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class StudentRegistration {
    private int userId; //学生ID
    private String name;   //学生姓名
    private String sex;    //学生性别
    private String school;  //学校
    private String numberJob; //历史兼职次数
    private String missNumber; //爽约次数
    private String phoneInfoUrl; //头像URL
    private String registrationTime; //报名时间
    private String leaveMessageMerchant; //给商家留言
    private String hired;//是否录用 1录用 0未录用
    private String postName; //岗位名称
    private double finalPay; //实发金额
    private String isOver; //是否已经结束 1 结束  0 未结束
    private String settlementWage; //是否已经结算工资 1 已结算 0 未结算
    private String generalEvaluation; //总评价
    private String businessHireTime; //商家录用时间
    private String studentsTime; // 大学生确认时间

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNumberJob() {
        return numberJob;
    }

    public void setNumberJob(String numberJob) {
        this.numberJob = numberJob;
    }

    public String getMissNumber() {
        return missNumber;
    }

    public void setMissNumber(String missNumber) {
        this.missNumber = missNumber;
    }

    public String getPhoneInfoUrl() {
        return phoneInfoUrl;
    }

    public void setPhoneInfoUrl(String phoneInfoUrl) {
        this.phoneInfoUrl = phoneInfoUrl;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getLeaveMessageMerchant() {
        return leaveMessageMerchant;
    }

    public void setLeaveMessageMerchant(String leaveMessageMerchant) {
        this.leaveMessageMerchant = leaveMessageMerchant;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public double getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public String getSettlementWage() {
        return settlementWage;
    }

    public void setSettlementWage(String settlementWage) {
        this.settlementWage = settlementWage;
    }

    public String getGeneralEvaluation() {
        return generalEvaluation;
    }

    public void setGeneralEvaluation(String generalEvaluation) {
        this.generalEvaluation = generalEvaluation;
    }

    public String getBusinessHireTime() {
        return businessHireTime;
    }

    public void setBusinessHireTime(String businessHireTime) {
        this.businessHireTime = businessHireTime;
    }

    public String getStudentsTime() {
        return studentsTime;
    }

    public void setStudentsTime(String studentsTime) {
        this.studentsTime = studentsTime;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", numberJob='" + numberJob + '\'' +
                ", missNumber='" + missNumber + '\'' +
                ", phoneInfoUrl='" + phoneInfoUrl + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", leaveMessageMerchant='" + leaveMessageMerchant + '\'' +
                ", hired='" + hired + '\'' +
                ", postName='" + postName + '\'' +
                ", finalPay=" + finalPay +
                ", isOver='" + isOver + '\'' +
                ", settlementWage='" + settlementWage + '\'' +
                ", generalEvaluation='" + generalEvaluation + '\'' +
                ", businessHireTime='" + businessHireTime + '\'' +
                ", studentsTime='" + studentsTime + '\'' +
                '}';
    }
}
