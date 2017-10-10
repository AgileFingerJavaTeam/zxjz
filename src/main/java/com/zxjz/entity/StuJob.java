package com.zxjz.entity;

public class StuJob {
    private String numberJob;
    private String total;
    private String amountOfMoney;
    private String portraitUrl;
    private String salaryTreatment;
    private String workLocation;
    private String workDate;
    private String studentsConfirmed;
    private String hired;
    private String isOver;
    private String postName;
    private String recruitingId;
    private String studentUserId;
    private String settlementMethod;

    public String getNumberJob() {
        return numberJob;
    }

    public void setNumberJob(String numberJob) {
        this.numberJob = numberJob;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getSalaryTreatment() {
        return salaryTreatment;
    }

    public void setSalaryTreatment(String salaryTreatment) {
        this.salaryTreatment = salaryTreatment;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getStudentsConfirmed() {
        return studentsConfirmed;
    }

    public void setStudentsConfirmed(String studentsConfirmed) {
        this.studentsConfirmed = studentsConfirmed;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(String recruitingId) {
        this.recruitingId = recruitingId;
    }

    public String getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(String studentUserId) {
        this.studentUserId = studentUserId;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    @Override
    public String toString() {
        return "StuJob{" +
                "numberJob='" + numberJob + '\'' +
                ", total='" + total + '\'' +
                ", amountOfMoney='" + amountOfMoney + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", salaryTreatment='" + salaryTreatment + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", workDate='" + workDate + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", hired='" + hired + '\'' +
                ", isOver='" + isOver + '\'' +
                ", postName='" + postName + '\'' +
                ", recruitingId='" + recruitingId + '\'' +
                ", studentUserId='" + studentUserId + '\'' +
                ", settlementMethod='" + settlementMethod + '\'' +
                '}';
    }
}
