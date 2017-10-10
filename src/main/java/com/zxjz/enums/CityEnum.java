package com.zxjz.enums;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public enum CityEnum{

    FIND_SUCCESS(1,"查询成功"),
    FIND_ERROR(-1,"查询错误");

    private int code;

    private String codeInfo;

    CityEnum(int code, String codeInfo) {
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

    public static CityEnum stateof(int index) {
        for (CityEnum state : values())
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
        return "CityEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
