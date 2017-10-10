package com.zxjz.dto.in;

public class StuPersonalDto {
    private int userID;

    public StuPersonalDto(int userID) {
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
        return "StuPersonalDto{" +
                "userID=" + userID +
                '}';
    }
}
