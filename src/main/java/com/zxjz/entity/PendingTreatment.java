package com.zxjz.entity;

import com.sun.beans.editors.DoubleEditor;

public class PendingTreatment {
    private int id;
    private int recruitId;// 招聘ID
    private int collegeUserId;// 大学生用户ID
    private int workId;// 工作ID
    private String postName;// 岗位名称
    private String registrationTime;// 报名时间
    private String studentName;// 大学生姓名
    private String sex;// 学生性别
    private String headPic;// 学生头像URL
    private String numberJob;// 兼职次数
    private Double moneyAmount;// 累计金额
    private String recentlyPaidTime;// 最近支付时间
    private String afterConfirmation;// 录取后有效的确认时间
    private String settlementMethod;//结算方式
    private int salaryTreatment;//工作薪资

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNumberJob() {
        return numberJob;
    }

    public void setNumberJob(String numberJob) {
        this.numberJob = numberJob;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getRecentlyPaidTime() {
        return recentlyPaidTime;
    }

    public void setRecentlyPaidTime(String recentlyPaidTime) {
        this.recentlyPaidTime = recentlyPaidTime;
    }

    public String getAfterConfirmation() {
        return afterConfirmation;
    }

    public void setAfterConfirmation(String afterConfirmation) {
        this.afterConfirmation = afterConfirmation;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public int getSalaryTreatment() {
        return salaryTreatment;
    }

    public void setSalaryTreatment(int salaryTreatment) {
        this.salaryTreatment = salaryTreatment;
    }

    @Override
    public String toString() {
        return "PendingTreatment{" +
                "id=" + id +
                ", recruitId=" + recruitId +
                ", collegeUserId=" + collegeUserId +
                ", workId=" + workId +
                ", postName='" + postName + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                ", headPic='" + headPic + '\'' +
                ", numberJob='" + numberJob + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", recentlyPaidTime='" + recentlyPaidTime + '\'' +
                ", afterConfirmation='" + afterConfirmation + '\'' +
                ", settlementMethod='" + settlementMethod + '\'' +
                ", salaryTreatment=" + salaryTreatment +
                '}';
    }
}
