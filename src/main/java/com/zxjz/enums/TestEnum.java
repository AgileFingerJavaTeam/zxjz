package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/10/12.
 */
public enum TestEnum {
    SUCCESS(1);//成功

    private int code;

    TestEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
