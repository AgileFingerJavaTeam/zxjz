package com.zxjz.entity;

public class MerchantApprovalInfo {
    //员工
    private int employeesId;
    private String employeesName;
    //
    private int approvalId;//审核ID
    private int userId;//用户ID
    private String approvalNum;//申请序号
    private String applyTime;//申请时间
    private String companyName;//公司名称
    private String industryInvolved;//所属行业
    private String companyAddress;//公司地址
    private String longitude;//经度
    private String latitude;//纬度
    private String head;//负责人
    private String job;//职位
    private String phone;//电话
    private String url;//营业执照URL
    private String status;//审核状态
    private String auditStaff;//审核员工
    private String auditTime;//审核时间
    private String note;//备注
    private String portraitUrl;//头像地址
    private String logoUrl;

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(String approvalNum) {
        this.approvalNum = approvalNum;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustryInvolved() {
        return industryInvolved;
    }

    public void setIndustryInvolved(String industryInvolved) {
        this.industryInvolved = industryInvolved;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStaff() {
        return auditStaff;
    }

    public void setAuditStaff(String auditStaff) {
        this.auditStaff = auditStaff;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "MerchantApprovalInfo{" +
                "employeesId=" + employeesId +
                ", employeesName='" + employeesName + '\'' +
                ", approvalId=" + approvalId +
                ", userId=" + userId +
                ", approvalNum='" + approvalNum + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industryInvolved='" + industryInvolved + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", head='" + head + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", auditStaff='" + auditStaff + '\'' +
                ", auditTime='" + auditTime + '\'' +
                ", note='" + note + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
