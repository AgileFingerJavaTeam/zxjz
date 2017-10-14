package com.zxjz.entity;

public class BoundPhoneInfo {
    private String bound_phone;

    public String getBound_phone() {
        return bound_phone;
    }

    public void setBound_phone(String bound_phone) {
        this.bound_phone = bound_phone;
    }

    @Override
    public String toString() {
        return "BoundPhoneInfo{" +
                "bound_phone='" + bound_phone + '\'' +
                '}';
    }
}
