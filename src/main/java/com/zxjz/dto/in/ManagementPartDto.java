package com.zxjz.dto.in;

public class ManagementPartDto {
    private int userID;
    private String recruitmentListType;

    public ManagementPartDto(int userID, String recruitmentListType) {
        this.userID = userID;
        this.recruitmentListType = recruitmentListType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRecruitmentListType() {
        return recruitmentListType;
    }

    public void setRecruitmentListType(String recruitmentListType) {
        this.recruitmentListType = recruitmentListType;
    }

    @Override
    public String toString() {
        return "ManagementPartDto{" +
                "userID=" + userID +
                ", recruitmentListType='" + recruitmentListType + '\'' +
                '}';
    }
}
