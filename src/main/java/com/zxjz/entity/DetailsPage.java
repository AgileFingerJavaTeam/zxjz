package com.zxjz.entity;

public class DetailsPage {
    private int userId;// 学生用户ID
    private String studentName;// 学生名称
    private String school;// 学校
    private String sex;// 性别
    private String phone;// 学生手机号
    private float generalEvaluation;// 学生评价总评分(星级)
    private String headPic;// 学生头像
    private String leaveMessageMerchant;// 给商家留言
    private String hired;// 是否录用
    private String settlementWage;// 是否结算
    private String settlementTime;// 结算时间
    private String isOver;// 是否已经结束
    private String registrationTime;// 报名时间
    private String businessHireTime;// 录用时间
    private String studentsConfirmed;// 大学生是否确认
    private String studentsTime;// 大学生确认时间
    private int missNumber;
    private String detailsPageCategory; //是否是担保职位

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getGeneralEvaluation() {
        return generalEvaluation;
    }

    public void setGeneralEvaluation(float generalEvaluation) {
        this.generalEvaluation = generalEvaluation;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getLeaveMessageMerchant() {
        return leaveMessageMerchant;
    }

    public void setLeaveMessageMerchant(String leaveMessageMerchant) {
        this.leaveMessageMerchant = leaveMessageMerchant;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getSettlementWage() {
        return settlementWage;
    }

    public void setSettlementWage(String settlementWage) {
        this.settlementWage = settlementWage;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
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

    public int getMissNumber() {
        return missNumber;
    }

    public void setMissNumber(int missNumber) {
        this.missNumber = missNumber;
    }

    public String getDetailsPageCategory() {
        return detailsPageCategory;
    }

    public void setDetailsPageCategory(String detailsPageCategory) {
        this.detailsPageCategory = detailsPageCategory;
    }

    @Override
    public String toString() {
        return "DetailsPage{" +
                "userId=" + userId +
                ", studentName='" + studentName + '\'' +
                ", school='" + school + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", generalEvaluation=" + generalEvaluation +
                ", headPic='" + headPic + '\'' +
                ", leaveMessageMerchant='" + leaveMessageMerchant + '\'' +
                ", hired='" + hired + '\'' +
                ", settlementWage='" + settlementWage + '\'' +
                ", settlementTime='" + settlementTime + '\'' +
                ", isOver='" + isOver + '\'' +
                ", registrationTime='" + registrationTime + '\'' +
                ", businessHireTime='" + businessHireTime + '\'' +
                ", studentsConfirmed='" + studentsConfirmed + '\'' +
                ", studentsTime='" + studentsTime + '\'' +
                ", missNumber=" + missNumber +
                ", detailsPageCategory='" + detailsPageCategory + '\'' +
                '}';
    }
}
