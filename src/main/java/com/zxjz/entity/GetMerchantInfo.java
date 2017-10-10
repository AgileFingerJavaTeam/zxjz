package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class GetMerchantInfo {
    private int userId;//商户用户ID
    private String url;//企业Logo
    private int jobId;//行业ID
    private String companyScale;//公司规模
    private String address;//公司地址
    private String iName;//行业名称
    private String portraitUrl;//商户头像
    private String merchantsName;//商户名称
    private String introduce;//公司介绍
    private String text;//行业

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "GetMerchantInfo{" +
                "userId=" + userId +
                ", url='" + url + '\'' +
                ", jobId=" + jobId +
                ", companyScale='" + companyScale + '\'' +
                ", address='" + address + '\'' +
                ", iName='" + iName + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", introduce='" + introduce + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
