package com.zxjz.dto.excution;

import com.zxjz.entity.KeywordSearch;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class KeywordSearchExcution {
    private List<KeywordSearch> keywordSearcheList;
    private int code;
    private String codeInfo;

    public KeywordSearchExcution(List<KeywordSearch> keywordSearcheList, StuPersonalEnum stuPersonalEnum) {
        this.keywordSearcheList = keywordSearcheList;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public KeywordSearchExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public List<KeywordSearch> getKeywordSearcheList() {
        return keywordSearcheList;
    }

    public void setKeywordSearcheList(List<KeywordSearch> keywordSearcheList) {
        this.keywordSearcheList = keywordSearcheList;
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
        return "KeywordSearchExcution{" +
                "keywordSearcheList=" + keywordSearcheList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
