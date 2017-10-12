package com.zxjz.dto.excution;

import com.zxjz.entity.IndustryClassification;
import com.zxjz.enums.CityEnum;

import java.util.List;

public class IndustryClassificationExcution {
    private List<IndustryClassification> listIndustryClassification;
    private int code;
    private String codeInfo;

    public IndustryClassificationExcution(List<IndustryClassification> listIndustryClassification, CityEnum cityEnum) {
        this.listIndustryClassification = listIndustryClassification;
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public IndustryClassificationExcution(CityEnum cityEnum) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public List<IndustryClassification> getListIndustryClassification() {
        return listIndustryClassification;
    }

    public void setListIndustryClassification(List<IndustryClassification> listIndustryClassification) {
        this.listIndustryClassification = listIndustryClassification;
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
        return "IndustryClassificationExcution{" +
                "listIndustryClassification=" + listIndustryClassification +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
