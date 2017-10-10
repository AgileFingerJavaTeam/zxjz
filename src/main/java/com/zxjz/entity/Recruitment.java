package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class Recruitment {
    private int  recruitingId;
    private int releasesUserId;
    private int applyNum;
    private String applyTime;
    private String postName;
    private int  postClassification;
    private String detailsPageCategoryategory;
    private String workDate;
    private String workTime;
    private String workLocation;
    private String positionLongitude;
    private String positionLatitude	;
    private String workContent;
    private String settlementMethod;
    private String  salaryTreatment;
    private String commission	;
    private String benefits	;
    private String genderRequirements;
    private int  recruitment;
    private int peopleNum;
    private String hiringExpirationDate;
    private int auditor;
    private String statusTime;
    private String  statusResult;
    private String dismissedReason	;
    private String auditStatus;
    private String leader;
    private String leaderPhone;
    private int  city;

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getReleasesUserId() {
        return releasesUserId;
    }

    public void setReleasesUserId(int releasesUserId) {
        this.releasesUserId = releasesUserId;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public int getPostClassification() {
        return postClassification;
    }

    public void setPostClassification(int postClassification) {
        this.postClassification = postClassification;
    }

    public String getDetailsPageCategoryategory() {
        return detailsPageCategoryategory;
    }

    public void setDetailsPageCategoryategory(String detailsPageCategoryategory) {
        this.detailsPageCategoryategory = detailsPageCategoryategory;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(String positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public String getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(String positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getSalaryTreatment() {
        return salaryTreatment;
    }

    public void setSalaryTreatment(String salaryTreatment) {
        this.salaryTreatment = salaryTreatment;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getGenderRequirements() {
        return genderRequirements;
    }

    public void setGenderRequirements(String genderRequirements) {
        this.genderRequirements = genderRequirements;
    }

    public int getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(int recruitment) {
        this.recruitment = recruitment;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getHiringExpirationDate() {
        return hiringExpirationDate;
    }

    public void setHiringExpirationDate(String hiringExpirationDate) {
        this.hiringExpirationDate = hiringExpirationDate;
    }

    public int getAuditor() {
        return auditor;
    }

    public void setAuditor(int auditor) {
        this.auditor = auditor;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }

    public String getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(String statusResult) {
        this.statusResult = statusResult;
    }

    public String getDismissedReason() {
        return dismissedReason;
    }

    public void setDismissedReason(String dismissedReason) {
        this.dismissedReason = dismissedReason;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "recruitingId=" + recruitingId +
                ", releasesUserId=" + releasesUserId +
                ", applyNum=" + applyNum +
                ", applyTime='" + applyTime + '\'' +
                ", postName='" + postName + '\'' +
                ", postClassification=" + postClassification +
                ", detailsPageCategoryategory='" + detailsPageCategoryategory + '\'' +
                ", workDate='" + workDate + '\'' +
                ", workTime='" + workTime + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", positionLongitude='" + positionLongitude + '\'' +
                ", positionLatitude='" + positionLatitude + '\'' +
                ", workContent='" + workContent + '\'' +
                ", settlementMethod='" + settlementMethod + '\'' +
                ", salaryTreatment='" + salaryTreatment + '\'' +
                ", commission='" + commission + '\'' +
                ", benefits='" + benefits + '\'' +
                ", genderRequirements='" + genderRequirements + '\'' +
                ", recruitment=" + recruitment +
                ", peopleNum=" + peopleNum +
                ", hiringExpirationDate='" + hiringExpirationDate + '\'' +
                ", auditor=" + auditor +
                ", statusTime='" + statusTime + '\'' +
                ", statusResult='" + statusResult + '\'' +
                ", dismissedReason='" + dismissedReason + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", leader='" + leader + '\'' +
                ", leaderPhone='" + leaderPhone + '\'' +
                ", city=" + city +
                '}';
    }
}
