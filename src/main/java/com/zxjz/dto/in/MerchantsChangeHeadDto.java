package com.zxjz.dto.in;

public class MerchantsChangeHeadDto {
    private String head;//负责人
    private String job;//职位
    private String phone;//手机号
    private  int userId;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MerchantsChangeHeadDto{" +
                "head='" + head + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                '}';
    }
}
