package com.zxjz.entity;

public class StuEvaDetails {
    private int evaluateId;// 评价ID
    private int userId;// 用户ID
    private int jobId;// 兼职ID
    private int merchantId;// 商户ID
    private String comprehensiveEvaluateScore;// 综合评价得分
    private String wordsEvaluate;// 文字评价
    private String descriptiveCorre;// 描述相符
    private String punctualityIdea;// 守时观念
    private String conscientiousness;// 责任心
    private String workingAbility;// 工作能力
    private String compreEvaluation;// 综合评价
    private String commentTime;// 评论时间
    private String portraitUrl;// 用户头像URL
    private String merchantsName;// 商户名称

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getComprehensiveEvaluateScore() {
        return comprehensiveEvaluateScore;
    }

    public void setComprehensiveEvaluateScore(String comprehensiveEvaluateScore) {
        this.comprehensiveEvaluateScore = comprehensiveEvaluateScore;
    }

    public String getWordsEvaluate() {
        return wordsEvaluate;
    }

    public void setWordsEvaluate(String wordsEvaluate) {
        this.wordsEvaluate = wordsEvaluate;
    }

    public String getDescriptiveCorre() {
        return descriptiveCorre;
    }

    public void setDescriptiveCorre(String descriptiveCorre) {
        this.descriptiveCorre = descriptiveCorre;
    }

    public String getPunctualityIdea() {
        return punctualityIdea;
    }

    public void setPunctualityIdea(String punctualityIdea) {
        this.punctualityIdea = punctualityIdea;
    }

    public String getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(String conscientiousness) {
        this.conscientiousness = conscientiousness;
    }

    public String getWorkingAbility() {
        return workingAbility;
    }

    public void setWorkingAbility(String workingAbility) {
        this.workingAbility = workingAbility;
    }

    public String getCompreEvaluation() {
        return compreEvaluation;
    }

    public void setCompreEvaluation(String compreEvaluation) {
        this.compreEvaluation = compreEvaluation;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
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

    @Override
    public String toString() {
        return "StuEvaDetails{" +
                "evaluateId=" + evaluateId +
                ", userId=" + userId +
                ", jobId=" + jobId +
                ", merchantId=" + merchantId +
                ", comprehensiveEvaluateScore='" + comprehensiveEvaluateScore + '\'' +
                ", wordsEvaluate='" + wordsEvaluate + '\'' +
                ", descriptiveCorre='" + descriptiveCorre + '\'' +
                ", punctualityIdea='" + punctualityIdea + '\'' +
                ", conscientiousness='" + conscientiousness + '\'' +
                ", workingAbility='" + workingAbility + '\'' +
                ", compreEvaluation='" + compreEvaluation + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                '}';
    }
}
