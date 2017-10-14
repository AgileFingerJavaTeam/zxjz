package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public enum MerchantEnum {
    FIND_SUCCESS(1),//查询精品职位成功
    FIND_ERROR(-1),//查询精品职位失败
    ORDINARY_FIND_SUCCESS(2),//查询普通职位成功
    FIND_MERCHANT_SUCCESS(3);//查询商家成功


    private int code;

    MerchantEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}