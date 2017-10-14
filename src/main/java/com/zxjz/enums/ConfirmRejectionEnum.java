package com.zxjz.enums;

public enum ConfirmRejectionEnum {
    REJECT_SUCCESS(1),//您已拒绝录用该学生
    REJECT_ERROR(-1),//拒绝失败
    HIRED_ERROR(-2),//录用失败
    HIRED_SUCCESS(2);//录用成功

    private int code;

    ConfirmRejectionEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
