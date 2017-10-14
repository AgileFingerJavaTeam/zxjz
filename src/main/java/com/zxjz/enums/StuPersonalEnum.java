package com.zxjz.enums;

public enum StuPersonalEnum {

    FIND_SUCCESS(1),//查询成功
    FIND_ERROR(-1);//查询错误

    private int code;

    StuPersonalEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
