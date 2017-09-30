package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class ListCollection {

    private int recruitingId; //招聘ID
    private int userId; //用户ID
    private String merchantsName; //商户名称
    private String logoUrl; //商户LOGO地址
    private String postName; //岗位名称
    private double salaryTreatment; //工资待遇
    private String workLocation; //工作地点
    private String workTime; //工作时间
    private String merchantsLevel; //商户等级
    private String isStar; //是否是明星雇主

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getMerchantsLevel() {
        return merchantsLevel;
    }

    public void setMerchantsLevel(String merchantsLevel) {
        this.merchantsLevel = merchantsLevel;
    }

    public String getIsStar() {
        return isStar;
    }

    public void setIsStar(String isStar) {
        this.isStar = isStar;
    }

    @Override
    public String toString() {
        return "ListCollection{" +
                "recruitingId=" + recruitingId +
                ", userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", postName='" + postName + '\'' +
                ", salaryTreatment=" + salaryTreatment +
                ", workLocation='" + workLocation + '\'' +
                ", workTime='" + workTime + '\'' +
                ", merchantsLevel='" + merchantsLevel + '\'' +
                ", isStar='" + isStar + '\'' +
                '}';
    }
}
