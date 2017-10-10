package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class GuaranteePositionInfo extends RecruitmentInfo {

    private String mainTitle;	//主标题
    private String subtitle;	//副标题
    private String pageUrl;	//封页图URL
    private String firstPageUrl;	//首页图URL
    private String firstPageCarouselUrl;	//首页图URL（用于App首页轮播的图片）
    private String mainPageUrl;	//详情页主图URL
    private String detailsPageIntroduction;	//详情页介绍（富文本）
    public RecruitmentInfo recruitmentInfo;

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public String getFirstPageCarouselUrl() {
        return firstPageCarouselUrl;
    }

    public void setFirstPageCarouselUrl(String firstPageCarouselUrl) {
        this.firstPageCarouselUrl = firstPageCarouselUrl;
    }

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public void setMainPageUrl(String mainPageUrl) {
        this.mainPageUrl = mainPageUrl;
    }

    public String getDetailsPageIntroduction() {
        return detailsPageIntroduction;
    }

    public void setDetailsPageIntroduction(String detailsPageIntroduction) {
        this.detailsPageIntroduction = detailsPageIntroduction;
    }

    public RecruitmentInfo getRecruitmentInfo() {
        return recruitmentInfo;
    }

    public void setRecruitmentInfo(RecruitmentInfo recruitmentInfo) {
        this.recruitmentInfo = recruitmentInfo;
    }

    @Override
    public String toString() {
        return "GuaranteePositionInfo{" +
                "mainTitle='" + mainTitle + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", firstPageUrl='" + firstPageUrl + '\'' +
                ", firstPageCarouselUrl='" + firstPageCarouselUrl + '\'' +
                ", mainPageUrl='" + mainPageUrl + '\'' +
                ", detailsPageIntroduction='" + detailsPageIntroduction + '\'' +
                ", recruitmentInfo=" + recruitmentInfo +
                '}';
    }
}
