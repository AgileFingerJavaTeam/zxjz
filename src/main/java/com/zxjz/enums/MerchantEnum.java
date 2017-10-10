package com.zxjz.enums;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public enum MerchantEnum {
    FIND_SUCCESS(1, "查询精品职位成功"),
    ORDINARY_FIND_SUCCESS(2, "查询普通职位成功"),
    FIND_MERCHANT_SUCCESS(3, "查询商家成功");


    private int code;
    private String codeInfo;

    MerchantEnum(int code, String codeInfo) {
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
        return "MerchantEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }

    public static MerchantEnum stateof(int index) {
        for (MerchantEnum state : values())
        {
            if (state.getCode()==index)
            {
                return state;
            }
        }
        return null;
    }

}