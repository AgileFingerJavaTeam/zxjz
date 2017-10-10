package com.zxjz.dto.in;

public class StuEvaDetailsDto {
    private int userID;

    public StuEvaDetailsDto(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "StuEvaDetailsDto{" +
                "userID=" + userID +
                '}';
    }
}
