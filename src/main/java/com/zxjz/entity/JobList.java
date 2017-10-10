package com.zxjz.entity;

public class JobList {
    private int recruitingId;//招聘ID
    private String postName;//岗位名称
    private double salaryTreatment;//工资待遇
    private String workDate;//工作日期
    private String workLocation;//工作地点
    private String portraitUrl;//商家Logo
    private String merchantsName;//商家名称
    private String isStar;//是否是明星雇主
    private String detailsPageCategory;//是否是担保
    private String settlementMethod;//结算方式

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public double getSalaryTreatment() {
        return salaryTreatment;
    }

    public void setSalaryTreatment(double salaryTreatment) {
        this.salaryTreatment = salaryTreatment;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getIsStar() {
        return isStar;
    }

    public void setIsStar(String isStar) {
        this.isStar = isStar;
    }

    public String getDetailsPageCategory() {
        return detailsPageCategory;
    }

    public void setDetailsPageCategory(String detailsPageCategory) {
        this.detailsPageCategory = detailsPageCategory;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    @Override
    public String toString() {
        return "JobList{" +
                "recruitingId=" + recruitingId +
                ", postName='" + postName + '\'' +
                ", salaryTreatment=" + salaryTreatment +
                ", workDate='" + workDate + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", isStar='" + isStar + '\'' +
                ", detailsPageCategory='" + detailsPageCategory + '\'' +
                ", settlementMethod='" + settlementMethod + '\'' +
                '}';
    }
}
