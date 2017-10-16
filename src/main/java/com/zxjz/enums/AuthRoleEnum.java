package com.zxjz.enums;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public enum AuthRoleEnum {
    SUCCESS (1), //成功
    FAIL(2); //失败
    private int code;

    AuthRoleEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AuthRoleEnum{" +
                "code=" + code +
                '}';
    }
}
