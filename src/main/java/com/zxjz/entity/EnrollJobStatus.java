package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class EnrollJobStatus {
    private int recruitingId;  // 招聘ID
    private int releasesUserId;  // 用户ID
    private String merchantChecked; // 商家是否已经查看
    private String merchantTime; //商家查看时间
    private String hired; //商家是否已经录用
    private String businessHireTime; //商家录用时间
    private String studentsConfirmed; //大学生是否已经确认
    private String studentsTime; //大学生确认时间
    private String afterConfirmation;  //有效确认时限
    private String miss; // 是否爽约 1爽约 0没爽约
    private String detailsPageCategory; // 详情页面分类（普通／精品）
    private String postName; // 岗位名称
    private String workTime; // 工作时间
    private String workLocation; //工作地点
    private String salaryTreatment; //工资待遇
    private String portraitUrl; //公司LOGO
    private String isOver; //是否已经结束

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

    public String getAfterConfirmation() {
        return afterConfirmation;
    }

    public void setAfterConfirmation(String afterConfirmation) {
        this.afterConfirmation = afterConfirmation;
    }

    public String getMiss() {
        return miss;
    }

    public void setMiss(String miss) {
        this.miss = miss;
    }

    public String getDetailsPageCategory() {
        return detailsPageCategory;
    }

    public void setDetailsPageCategory(String detailsPageCategory) {
        this.detailsPageCategory = detailsPageCategory;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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

    public String getSalaryTreatment() {
        return salaryTreatment;
    }

    public void setSalaryTreatment(String salaryTreatment) {
        this.salaryTreatment = salaryTreatment;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    @Override
    public String toString() {
        return "EnrollJobStatus{" +
                "recruitingId=" + recruitingId +
                ", releasesUserId=" + releasesUserId +
                ", merchantChecked='" + merchantChecked + '\'' +
                ", merchantTime='" + merchantTime + '\'' +
                ", hired='" + hired + '\'' +
                ", businessHireTime='" + businessHireTime + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", studentsTime='" + studentsTime + '\'' +
                ", afterConfirmation='" + afterConfirmation + '\'' +
                ", miss='" + miss + '\'' +
                ", detailsPageCategory='" + detailsPageCategory + '\'' +
                ", postName='" + postName + '\'' +
                ", workTime='" + workTime + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", salaryTreatment='" + salaryTreatment + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", isOver='" + isOver + '\'' +
                '}';
    }
}
