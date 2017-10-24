package com.zxjz.entity;

public class StuMsg {
  private String regDatetime;
  private String name;
  private String sex;
  private String phone;
  private String school;
  private String state;
  private  int userId;
  private String isLook;

    public String getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(String regDatetime) {
        this.regDatetime = regDatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIsLook() {
        return isLook;
    }

    public void setIsLook(String isLook) {
        this.isLook = isLook;
    }

    @Override
    public String toString() {
        return "StuMsg{" +
                "regDatetime='" + regDatetime + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", school='" + school + '\'' +
                ", state='" + state + '\'' +
                ", userId=" + userId +
                ", isLook='" + isLook + '\'' +
                '}';
    }
}
