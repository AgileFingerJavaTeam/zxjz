package com.zxjz.enums;

public enum CodeEnum {

    MSG_UID("agilefinger"),
    MSG_KEY("1c91d4ff68ae33b3d28e");

    private String info;

    CodeEnum(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
