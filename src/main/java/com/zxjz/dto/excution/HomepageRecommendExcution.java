package com.zxjz.dto.excution;

import com.zxjz.enums.HomepageRecommendEnum;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class HomepageRecommendExcution {

    private int code;
    private String codeInfo;

    public HomepageRecommendExcution(HomepageRecommendEnum homepageRecommendEnum) {
        this.code = homepageRecommendEnum.getCode();
        this.codeInfo = homepageRecommendEnum.getCodeInfo();
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
        return "HomepageRecommendExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
