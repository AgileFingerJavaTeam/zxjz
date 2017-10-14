package com.zxjz.enums;

public enum UpdatePauseEnum {

    UPDATE_SUCCESS(1),//更新成功
    UPDATE_ERROR(-1);//更新失败

    private int code;

    UpdatePauseEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
