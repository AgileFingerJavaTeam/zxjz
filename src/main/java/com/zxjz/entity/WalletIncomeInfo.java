package com.zxjz.entity;

public class WalletIncomeInfo {
    private Integer userId;
    private Integer  runningAccountNumber;
    private String time;
    private String classification;
    private String explain;
    private Double amountOfMoney;
    private String name;
    private String postName;
    private String portraitUrl;
    private String targetId;
    private String workId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRunningAccountNumber() {
        return runningAccountNumber;
    }

    public void setRunningAccountNumber(Integer runningAccountNumber) {
        this.runningAccountNumber = runningAccountNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "WalletIncomeInfo{" +
                "userId=" + userId +
                ", runningAccountNumber=" + runningAccountNumber +
                ", time='" + time + '\'' +
                ", classification='" + classification + '\'' +
                ", explain='" + explain + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                ", name='" + name + '\'' +
                ", postName='" + postName + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", targetId='" + targetId + '\'' +
                ", workId='" + workId + '\'' +
                '}';
    }
}
