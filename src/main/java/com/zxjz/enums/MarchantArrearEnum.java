package com.zxjz.enums;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public enum  MarchantArrearEnum {
    SUCCESS (1), //成功
    FAIL(2), //失败
    ERROR(99);//内部错误

    private int code;

    MarchantArrearEnum(int code) {
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
        return "MarchantArrearEnum{" +
                "code=" + code +
                '}';
    }

}
