package com.zxjz.entity;

public class MerchantsAccount {
    private int userId;
    private  String merchantsLevel;//商户等级
    private  String vipStart;//VIP开始时间
    private  String vipEnd;//VIP结束时间
    private  String merchantsClass;//商户类别
    private  String mainAccountUserId;//主账号ID
    private  String merchantsName;//商户名称
    private  String merchantsShort;//商户简称
    private  int jobId;//所属行业ID
    private  String head;//负责人
    private  String job;//职位
    private  String phone;//电话
    private  String url;//企业营业执照URL
    private  String address;//地址
    private  String longitude;//经度
    private  String latitude;//维度
    private  String introduce;//介绍
    private  String isStar;//是否明星雇主
    private  String isRecheneinheit;//是否由主账户统一结算
    private  String merchantsState;//商户状态
    private  String companyScale;//公司规模
    private int remainingRefreshTimes;//剩余刷新次数
    private int recruitingId;//招聘ID
    private int studentUserId;//学生ID

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMerchantsLevel() {
        return merchantsLevel;
    }

    public void setMerchantsLevel(String merchantsLevel) {
        this.merchantsLevel = merchantsLevel;
    }

    public String getVipStart() {
        return vipStart;
    }

    public void setVipStart(String vipStart) {
        this.vipStart = vipStart;
    }

    public String getVipEnd() {
        return vipEnd;
    }

    public void setVipEnd(String vipEnd) {
        this.vipEnd = vipEnd;
    }

    public String getMerchantsClass() {
        return merchantsClass;
    }

    public void setMerchantsClass(String merchantsClass) {
        this.merchantsClass = merchantsClass;
    }

    public String getMainAccountUserId() {
        return mainAccountUserId;
    }

    public void setMainAccountUserId(String mainAccountUserId) {
        this.mainAccountUserId = mainAccountUserId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getMerchantsShort() {
        return merchantsShort;
    }

    public void setMerchantsShort(String merchantsShort) {
        this.merchantsShort = merchantsShort;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIsStar() {
        return isStar;
    }

    public void setIsStar(String isStar) {
        this.isStar = isStar;
    }

    public String getIsRecheneinheit() {
        return isRecheneinheit;
    }

    public void setIsRecheneinheit(String isRecheneinheit) {
        this.isRecheneinheit = isRecheneinheit;
    }

    public String getMerchantsState() {
        return merchantsState;
    }

    public void setMerchantsState(String merchantsState) {
        this.merchantsState = merchantsState;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public int getRemainingRefreshTimes() {
        return remainingRefreshTimes;
    }

    public void setRemainingRefreshTimes(int remainingRefreshTimes) {
        this.remainingRefreshTimes = remainingRefreshTimes;
    }

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(int studentUserId) {
        this.studentUserId = studentUserId;
    }

    @Override
    public String toString() {
        return "MerchantsAccount{" +
                "userId=" + userId +
                ", merchantsLevel='" + merchantsLevel + '\'' +
                ", vipStart='" + vipStart + '\'' +
                ", vipEnd='" + vipEnd + '\'' +
                ", merchantsClass='" + merchantsClass + '\'' +
                ", mainAccountUserId='" + mainAccountUserId + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", merchantsShort='" + merchantsShort + '\'' +
                ", jobId=" + jobId +
                ", head='" + head + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", url='" + url + '\'' +
                ", address='" + address + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", introduce='" + introduce + '\'' +
                ", isStar='" + isStar + '\'' +
                ", isRecheneinheit='" + isRecheneinheit + '\'' +
                ", merchantsState='" + merchantsState + '\'' +
                ", companyScale='" + companyScale + '\'' +
                ", remainingRefreshTimes=" + remainingRefreshTimes +
                ", recruitingId=" + recruitingId +
                ", studentUserId=" + studentUserId +
                '}';
    }
}
