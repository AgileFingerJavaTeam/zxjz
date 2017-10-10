package com.zxjz.enums;

public enum ConfirmRejectionEnum {
    REJECT_SUCCESS(1,"您已拒绝录用该学生"),
    REJECT_ERROR(-1,"拒绝失败"),
    HIRED_ERROR(-2,"录用失败"),
    HIRED_SUCCESS(2,"录用成功");

    private int code;

    private String codeInfo;

    ConfirmRejectionEnum(int code, String codeInfo) {
        this.code = code;
        this.codeInfo = codeInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    public static ConfirmRejectionEnum stateof(int index) {
        for (ConfirmRejectionEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConfirmRejectionEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
