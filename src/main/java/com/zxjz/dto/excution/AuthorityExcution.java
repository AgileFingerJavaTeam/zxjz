package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.IndustryClassificationEnum;

public class AuthorityExcution extends BaseAPIExcution{
    public AuthorityExcution(Object data, IndustryClassificationEnum industryClassificationEnum) {
        this.data = data;
        this.code = industryClassificationEnum.getCode();
    }

    public AuthorityExcution(IndustryClassificationEnum industryClassificationEnum) {
        this.code = industryClassificationEnum.getCode();
    }
}
