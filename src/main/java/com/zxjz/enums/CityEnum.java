package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public enum CityEnum{

    FIND_SUCCESS(1),//查询成功
    FIND_ERROR(-1);//查询错误

    private int code;

    CityEnum(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }




}
