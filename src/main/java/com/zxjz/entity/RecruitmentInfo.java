package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class RecruitmentInfo {
    private int recruitingId;	//招聘ID（主键，流水号）
    private int releasesUserId;//发布用户ID（外键）
    private String releaseTime;//发布时间
    private String refreshTime;//刷新时间
    private String postName;//岗位名称
    private String postClassification;//	岗位分类
    private String detailsPageCategory;//详情页面分类（普通／担保）
    private String whetherOnHomepageGuarantee;//是否上首页担保（是：可以在App首页担保职位中轮播）
    private String goodBeginTime;//首页担保开始日期
    private String goodEndTime;//首页担保结束日期
    private String whetherOnHomepageRecommend;//	是否上首页推荐（是：可以在App首页推荐精品列表中显示）
    private String recommendBeginTime;//推荐开始日期
    private String recommendEndTime;//推荐结束日期
    private String workDate;//	工作日期
    private String workTime;//工作时间
    private String workLocation;//	工作地点
    private String positionLongitude;//工作地点经度
    private String positionLatitude;//工作地点纬度
    private String workContent;//工作内容（文本）
    private String settlementMethod;//结算方式（日结／周结／月结／完工结算／平台支付随时提现）
    private String salaryTreatment;//工资待遇
    private String commission;//提成
    private String benefits;//福利
    private String genderRequirements;//性别要求
    private String otherRequirements;//其他要求
    private int recruitment;//招聘人数
    private int peopleNum;//已经报名人数
    private String hiringExpirationDate;//4.2.1.24	招聘到期时间
    private String auditStatus;//审核状态（待审核／已经通过／已经驳回）
    private int auditor;//审核人
    private String statusTime;//审核时间
    private String statusResult;//审核结果
    private String dismissedReason;//驳回原因
    private String recruitmentStatus;//招聘状态（进行中／已经暂停／已经结束／已经删除／已经被投诉下架）
    private int viewCount;//浏览次数
    private int collectionCount;//收藏次数
    private String reported;//是否被举报
    private String stationName;//职位类型名称
    private String merchantsName;//商家名称

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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(String refreshTime) {
        this.refreshTime = refreshTime;
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

    public String getDetailsPageCategory() {
        return detailsPageCategory;
    }

    public void setDetailsPageCategory(String detailsPageCategory) {
        this.detailsPageCategory = detailsPageCategory;
    }

    public String getWhetherOnHomepageGuarantee() {
        return whetherOnHomepageGuarantee;
    }

    public void setWhetherOnHomepageGuarantee(String whetherOnHomepageGuarantee) {
        this.whetherOnHomepageGuarantee = whetherOnHomepageGuarantee;
    }

    public String getGoodBeginTime() {
        return goodBeginTime;
    }

    public void setGoodBeginTime(String goodBeginTime) {
        this.goodBeginTime = goodBeginTime;
    }

    public String getGoodEndTime() {
        return goodEndTime;
    }

    public void setGoodEndTime(String goodEndTime) {
        this.goodEndTime = goodEndTime;
    }

    public String getWhetherOnHomepageRecommend() {
        return whetherOnHomepageRecommend;
    }

    public void setWhetherOnHomepageRecommend(String whetherOnHomepageRecommend) {
        this.whetherOnHomepageRecommend = whetherOnHomepageRecommend;
    }

    public String getRecommendBeginTime() {
        return recommendBeginTime;
    }

    public void setRecommendBeginTime(String recommendBeginTime) {
        this.recommendBeginTime = recommendBeginTime;
    }

    public String getRecommendEndTime() {
        return recommendEndTime;
    }

    public void setRecommendEndTime(String recommendEndTime) {
        this.recommendEndTime = recommendEndTime;
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

    public String getOtherRequirements() {
        return otherRequirements;
    }

    public void setOtherRequirements(String otherRequirements) {
        this.otherRequirements = otherRequirements;
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

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    @Override
    public String toString() {
        return "RecruitmentInfo{" +
                "recruitingId=" + recruitingId +
                ", releasesUserId=" + releasesUserId +
                ", releaseTime='" + releaseTime + '\'' +
                ", refreshTime='" + refreshTime + '\'' +
                ", postName='" + postName + '\'' +
                ", postClassification='" + postClassification + '\'' +
                ", detailsPageCategory='" + detailsPageCategory + '\'' +
                ", whetherOnHomepageGuarantee='" + whetherOnHomepageGuarantee + '\'' +
                ", goodBeginTime='" + goodBeginTime + '\'' +
                ", goodEndTime='" + goodEndTime + '\'' +
                ", whetherOnHomepageRecommend='" + whetherOnHomepageRecommend + '\'' +
                ", recommendBeginTime='" + recommendBeginTime + '\'' +
                ", recommendEndTime='" + recommendEndTime + '\'' +
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
                ", otherRequirements='" + otherRequirements + '\'' +
                ", recruitment=" + recruitment +
                ", peopleNum=" + peopleNum +
                ", hiringExpirationDate='" + hiringExpirationDate + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", auditor=" + auditor +
                ", statusTime='" + statusTime + '\'' +
                ", statusResult='" + statusResult + '\'' +
                ", dismissedReason='" + dismissedReason + '\'' +
                ", recruitmentStatus='" + recruitmentStatus + '\'' +
                ", viewCount=" + viewCount +
                ", collectionCount=" + collectionCount +
                ", reported='" + reported + '\'' +
                ", stationName='" + stationName + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                '}';
    }
}
