package com.zxjz.entity;

public class StuWallletBase {
    private int userId;
    private double balance;
    private String alipayId;
    private String wechatId;
    private int lastLevel;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public int getLastLevel() {
        return lastLevel;
    }

    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }

    @Override
    public String toString() {
        return "StuWallletBase{" +
                "userId=" + userId +
                ", balance=" + balance +
                ", alipayId='" + alipayId + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", lastLevel=" + lastLevel +
                '}';
    }
}
