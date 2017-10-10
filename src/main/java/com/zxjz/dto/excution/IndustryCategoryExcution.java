package com.zxjz.dto.excution;

import com.zxjz.entity.IndustryCategory;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class IndustryCategoryExcution {
    private List<IndustryCategory> getIndustryCategoryList;
    private int code;
    private String codeInfo;

    public IndustryCategoryExcution(List<IndustryCategory> getIndustryCategoryList, CityEnum cityEnum) {
        this.getIndustryCategoryList = getIndustryCategoryList;
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public IndustryCategoryExcution(CityEnum cityEnum) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public List<IndustryCategory> getGetIndustryCategoryList() {
        return getIndustryCategoryList;
    }

    public void setGetIndustryCategoryList(List<IndustryCategory> getIndustryCategoryList) {
        this.getIndustryCategoryList = getIndustryCategoryList;
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
        return "IndustryCategoryExcution{" +
                "getIndustryCategoryList=" + getIndustryCategoryList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
