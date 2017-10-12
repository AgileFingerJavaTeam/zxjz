package com.zxjz.dto.excution;

import com.zxjz.enums.HomepageGuaranteeEnum;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class HomepageGuaranteeExcution {

    private int code;
    private String codeInfo;

    public HomepageGuaranteeExcution(HomepageGuaranteeEnum homepageGuaranteeEnum) {
        this.code = homepageGuaranteeEnum.getCode();
        this.codeInfo = homepageGuaranteeEnum.getCodeInfo();
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
        return "HomepageGuaranteeExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
