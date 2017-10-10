package com.zxjz.enums;

public enum UpdatePauseEnum {

    UPDATE_SUCCESS(1,"更新成功"),
    UPDATE_ERROR(-1,"更新失败");

    private int code;

    private String codeInfo;

    UpdatePauseEnum(int code, String codeInfo) {
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

    public static UpdatePauseEnum stateof(int index) {
        for (UpdatePauseEnum state : values())
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
        return "UpdatePauseEnum{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
