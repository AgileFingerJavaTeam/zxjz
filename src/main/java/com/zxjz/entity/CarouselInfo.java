package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class CarouselInfo {
    private String carouselCode;
    private String carouselName;
    private int carouselFigureId;
    private int carouselFigureType;
    private String pictureUrl;
    private String targetType;
    private int targetId;
    private String targetUrl;
    private String isGoodPosition;
    private String targetParameter;
    private String startDate;
    private String endDate;
    private String state;
    private String operator;

    public String getCarouselCode() {
        return carouselCode;
    }

    public void setCarouselCode(String carouselCode) {
        this.carouselCode = carouselCode;
    }

    public String getCarouselName() {
        return carouselName;
    }

    public void setCarouselName(String carouselName) {
        this.carouselName = carouselName;
    }

    public int getCarouselFigureId() {
        return carouselFigureId;
    }

    public void setCarouselFigureId(int carouselFigureId) {
        this.carouselFigureId = carouselFigureId;
    }

    public int getCarouselFigureType() {
        return carouselFigureType;
    }

    public void setCarouselFigureType(int carouselFigureType) {
        this.carouselFigureType = carouselFigureType;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getIsGoodPosition() {
        return isGoodPosition;
    }

    public void setIsGoodPosition(String isGoodPosition) {
        this.isGoodPosition = isGoodPosition;
    }

    public String getTargetParameter() {
        return targetParameter;
    }

    public void setTargetParameter(String targetParameter) {
        this.targetParameter = targetParameter;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "CarouselInfo{" +
                "carouselCode='" + carouselCode + '\'' +
                ", carouselName='" + carouselName + '\'' +
                ", carouselFigureId=" + carouselFigureId +
                ", carouselFigureType=" + carouselFigureType +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", targetType='" + targetType + '\'' +
                ", targetId=" + targetId +
                ", targetUrl='" + targetUrl + '\'' +
                ", isGoodPosition='" + isGoodPosition + '\'' +
                ", targetParameter='" + targetParameter + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", state='" + state + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
