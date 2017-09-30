package com.zxjz.dto.excution;

import com.zxjz.enums.MerchantCommentEnum;

public class MerchantCommentExcution {

    private int code;
    private String codeInfo;

    public MerchantCommentExcution(MerchantCommentEnum merchantCommentEnum) {
        this.code = merchantCommentEnum.getCode();
        this.codeInfo = merchantCommentEnum.getCodeInfo();
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
        return "MerchantCommentExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
