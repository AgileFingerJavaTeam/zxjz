package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class RegistrationInfo {
    private int recruitingId;//招聘ID
    private int studentUserId;//大学生用户ID
    private int resumeSerialNumber;//简历序号
    private String registrationTime;//报名信息
    private String studentName;//大学生姓名
    private String contactPhone;//联系手机号
    private String leaveMessageMerchant;//给商家留言
    private String merchantChecked;//商家是否查看
    private String merchantTime;//商家查看时间
    private String hired;//商家是否已经录用
    private String businessHireTime;//商家录用时间
    private String studentsConfirmed;//大学生是否确认
    private String studentsTime;//大学生确认时间

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(int studentUserId) {
        this.studentUserId = studentUserId;
    }

    public int getResumeSerialNumber() {
        return resumeSerialNumber;
    }

    public void setResumeSerialNumber(int resumeSerialNumber) {
        this.resumeSerialNumber = resumeSerialNumber;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getLeaveMessageMerchant() {
        return leaveMessageMerchant;
    }

    public void setLeaveMessageMerchant(String leaveMessageMerchant) {
        this.leaveMessageMerchant = leaveMessageMerchant;
    }

    public String getMerchantChecked() {
        return merchantChecked;
    }

    public void setMerchantChecked(String merchantChecked) {
        this.merchantChecked = merchantChecked;
    }

    public String getMerchantTime() {
        return merchantTime;
    }

    public void setMerchantTime(String merchantTime) {
        this.merchantTime = merchantTime;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getBusinessHireTime() {
        return businessHireTime;
    }

    public void setBusinessHireTime(String businessHireTime) {
        this.businessHireTime = businessHireTime;
    }

    public String getStudentsConfirmed() {
        return studentsConfirmed;
    }

    public void setStudentsConfirmed(String studentsConfirmed) {
        this.studentsConfirmed = studentsConfirmed;
    }

    public String getStudentsTime() {
        return studentsTime;
    }

    public void setStudentsTime(String studentsTime) {
        this.studentsTime = studentsTime;
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" +
                "recruitingId=" + recruitingId +
                ", studentUserId=" + studentUserId +
                ", resumeSerialNumber=" + resumeSerialNumber +
                ", registrationTime='" + registrationTime + '\'' +
                ", studentName='" + studentName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", leaveMessageMerchant='" + leaveMessageMerchant + '\'' +
                ", merchantChecked='" + merchantChecked + '\'' +
                ", merchantTime='" + merchantTime + '\'' +
                ", hired='" + hired + '\'' +
                ", businessHireTime='" + businessHireTime + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", studentsTime='" + studentsTime + '\'' +
                '}';
    }
}
