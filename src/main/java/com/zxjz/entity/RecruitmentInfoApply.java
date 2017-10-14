package com.zxjz.entity;


public class RecruitmentInfoApply {
    private int recruitingId;	//招聘ID（主键，流水号）
    private int releasesUserId;//发布用户ID（外键）
    private String applyNum;//申请序号（第几次申请，默认为1）
    private String applyTime;// 申请时间
    private String postName;//岗位名称
    private String postClassification;//岗位名称
    private String stationName;//	岗位分类（职位分类ID）
    private String detailsPageCategory;//详情页面分类（普通／担保）
    private String workDate;// 工作日期
    private String workTime;//工作时间
    private String workLocation;//	工作地点）
    private String positionLongitude;//工作地点经度
    private String positionLatitude;//工作地点纬度
    private String workContent;//工作内容（富文本）
    private String settlementMethod;//结算方式（日结／周结／月结／完工结算／平台支付随时提现）
    private String salaryTreatment;//工资待遇
    private String commission;//提成
    private String benefits;//福利
    private String genderRequirements;//性别要求
    private int recruitment;//招聘人数
    private int peopleNum;//已经报名人数
    private String hiringExpirationDate;// 招聘到期时间
    private String auditStatus;//审核状态（草稿／待审核／已经通过／已经驳回）
    private String auditor;//审核人
    private String statusTime;//审核时间
    private String statusResult;//审核结果
    private String dismissedReason;//驳回原因
    private String merchantsName;//商户名称
    private String city;
    private int employeesId;
    private String employeesName;//操作人姓名
    private Integer studentUserId;
    private Integer resume_serialNumber;
    private String registrationTime;
    private String studentName;
    private Integer contactPhone;
    private String leaveMessageMerchant;
    private String merchantChecked;
    private String merchantTime;
    private String hired;
    private String businessHirTime;
    private String studentsConfirmed;
    private String studentsTime;

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

    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
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

    public String getPostClassification() {
        return postClassification;
    }

    public void setPostClassification(String postClassification) {
        this.postClassification = postClassification;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDetailsPageCategory() {
        return detailsPageCategory;
    }

    public void setDetailsPageCategory(String detailsPageCategory) {
        this.detailsPageCategory = detailsPageCategory;
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

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
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

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public Integer getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Integer studentUserId) {
        this.studentUserId = studentUserId;
    }

    public Integer getResume_serialNumber() {
        return resume_serialNumber;
    }

    public void setResume_serialNumber(Integer resume_serialNumber) {
        this.resume_serialNumber = resume_serialNumber;
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

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
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

    public String getBusinessHirTime() {
        return businessHirTime;
    }

    public void setBusinessHirTime(String businessHirTime) {
        this.businessHirTime = businessHirTime;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "RecruitmentInfoApply{" +
                "recruitingId=" + recruitingId +
                ", releasesUserId=" + releasesUserId +
                ", applyNum='" + applyNum + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", postName='" + postName + '\'' +
                ", postClassification='" + postClassification + '\'' +
                ", stationName='" + stationName + '\'' +
                ", detailsPageCategory='" + detailsPageCategory + '\'' +
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
                ", auditStatus='" + auditStatus + '\'' +
                ", auditor='" + auditor + '\'' +
                ", statusTime='" + statusTime + '\'' +
                ", statusResult='" + statusResult + '\'' +
                ", dismissedReason='" + dismissedReason + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", city='" + city + '\'' +
                ", employeesId=" + employeesId +
                ", employeesName='" + employeesName + '\'' +
                ", studentUserId=" + studentUserId +
                ", resume_serialNumber=" + resume_serialNumber +
                ", registrationTime='" + registrationTime + '\'' +
                ", studentName='" + studentName + '\'' +
                ", contactPhone=" + contactPhone +
                ", leaveMessageMerchant='" + leaveMessageMerchant + '\'' +
                ", merchantChecked='" + merchantChecked + '\'' +
                ", merchantTime='" + merchantTime + '\'' +
                ", hired='" + hired + '\'' +
                ", businessHirTime='" + businessHirTime + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", studentsTime='" + studentsTime + '\'' +
                '}';
    }
}
