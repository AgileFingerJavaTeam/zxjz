package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class QuickSignUp {
    private int recruitingId;
    private int studentUserId;
    private String registrationTime;
    private String studentName;
    private String contactPhone;
    private String code;
    private String sex;
    private String school;
    private String inforType;
    private String leaveMessageMerchant;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getInforType() {
        return inforType;
    }

    public void setInforType(String inforType) {
        this.inforType = inforType;
    }

    public String getLeaveMessageMerchant() {
        return leaveMessageMerchant;
    }

    public void setLeaveMessageMerchant(String leaveMessageMerchant) {
        this.leaveMessageMerchant = leaveMessageMerchant;
    }

    @Override
    public String toString() {
        return "QuickSignUp{" +
                "recruitingId=" + recruitingId +
                ", studentUserId=" + studentUserId +
                ", registrationTime='" + registrationTime + '\'' +
                ", studentName='" + studentName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", code='" + code + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", inforType='" + inforType + '\'' +
                ", leaveMessageMerchant='" + leaveMessageMerchant + '\'' +
                '}';
    }
}
