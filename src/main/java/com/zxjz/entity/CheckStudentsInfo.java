package com.zxjz.entity;

public class CheckStudentsInfo {
    private int userId;
    private String name;
    private String studentcardPic;
    private String stuNumber;
    private String idCard;
    private String idcardPic;
    private int checkState;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentcardPic() {
        return studentcardPic;
    }

    public void setStudentcardPic(String studentcardPic) {
        this.studentcardPic = studentcardPic;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdcardPic() {
        return idcardPic;
    }

    public void setIdcardPic(String idcardPic) {
        this.idcardPic = idcardPic;
    }

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }

    @Override
    public String toString() {
        return "CheckStudentsInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", studentcardPic='" + studentcardPic + '\'' +
                ", stuNumber='" + stuNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", idcardPic='" + idcardPic + '\'' +
                ", checkState=" + checkState +
                '}';
    }
}
