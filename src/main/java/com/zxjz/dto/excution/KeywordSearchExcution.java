package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.KeywordSearch;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class KeywordSearchExcution extends BaseAPIExcution{

    public KeywordSearchExcution(List<KeywordSearch> keywordSearcheList, StuPersonalEnum stuPersonalEnum) {
        this.data = keywordSearcheList;
        this.code = stuPersonalEnum.getCode();
    }

    public KeywordSearchExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
