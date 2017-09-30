package com.zxjz.enums;

public enum StudentSetBoundPhoneEnum {
     BIND_SUCCESS(1,"绑定成功"),
     RECOMPOSE_BOUNDPHONE_SUCCESS(2,"修改绑定手机号成功"),
     BIND_REPEAT(-1,"手机号已被绑定"),
     PASSWORD_ERROR(-2,"密码错误"),
     VERIFY_CODE_ERROR(-3,"验证码错误"),
     BIND_FAIL(-4,"绑定失败");


     private int code;
     private String codeInfo;

    StudentSetBoundPhoneEnum(int code, String codeInfo) {
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

    @Override
    public String toString() {
        return "StudentSetBoundPhoneEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
