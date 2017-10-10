package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class InformationCollectionInfo {
    private int recruitingId;//招聘ID
    private int studentUserId;//大学生用户ID
    private String collectionTime;//收藏时间

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

    public String getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(String collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public String toString() {
        return "InformationCollectionInfo{" +
                "recruitingId=" + recruitingId +
                ", studentUserId=" + studentUserId +
                ", collectionTime='" + collectionTime + '\'' +
                '}';
    }
}
