package com.zxjz.entity;

public class ManagementPart {
    private int recruitingId;//招聘ID
    private String portraitUrl;//商户头像URL
    private String postName;//招聘名称
    private int peopleNum = 0;//已报名人数
    private int employedNumber = 0;//已录取
    private int recruitment = 0;//招聘人数
    private String recruitmentStatus;//招聘状态
    private String auditStatus;//'草稿','待审核','已通过','已驳回'

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public int getEmployedNumber() {
        return employedNumber;
    }

    public void setEmployedNumber(int employedNumber) {
        this.employedNumber = employedNumber;
    }

    public int getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(int recruitment) {
        this.recruitment = recruitment;
    }

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Override
    public String toString() {
        return "ManagementPart{" +
                "recruitingId=" + recruitingId +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", postName='" + postName + '\'' +
                ", peopleNum=" + peopleNum +
                ", employedNumber=" + employedNumber +
                ", recruitment=" + recruitment +
                ", recruitmentStatus='" + recruitmentStatus + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                '}';
    }
}
