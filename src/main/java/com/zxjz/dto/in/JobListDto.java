package com.zxjz.dto.in;

public class JobListDto {
    private int selectType;
    private String sex;
    private String sexStr;
    private String starJob;
    private String cityType;
    private String jobType;
    private String paymentType;
    private String paymentTypeStr;
    private String orderType;

    public JobListDto(int selectType, String sex, String sexStr, String starJob, String cityType, String jobType, String paymentType, String paymentTypeStr, String orderType) {
        this.selectType = selectType;
        this.sex = sex;
        this.sexStr = sexStr;
        this.starJob = starJob;
        this.cityType = cityType;
        this.jobType = jobType;
        this.paymentType = paymentType;
        this.paymentTypeStr = paymentTypeStr;
        this.orderType = orderType;
    }

    public int getSelectType() {
        return selectType;
    }

    public void setSelectType(int selectType) {
        this.selectType = selectType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getStarJob() {
        return starJob;
    }

    public void setStarJob(String starJob) {
        this.starJob = starJob;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeStr() {
        return paymentTypeStr;
    }

    public void setPaymentTypeStr(String paymentTypeStr) {
        this.paymentTypeStr = paymentTypeStr;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "JobListDto{" +
                "selectType=" + selectType +
                ", sex='" + sex + '\'' +
                ", sexStr='" + sexStr + '\'' +
                ", starJob='" + starJob + '\'' +
                ", cityType='" + cityType + '\'' +
                ", jobType='" + jobType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTypeStr='" + paymentTypeStr + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
