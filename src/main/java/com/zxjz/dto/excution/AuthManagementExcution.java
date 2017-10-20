package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.IndustryClassificationEnum;

public class AuthManagementExcution extends BaseAPIExcution{
    public AuthManagementExcution(Object data, IndustryClassificationEnum industryClassificationEnum) {
        this.data = data;
        this.code = industryClassificationEnum.getCode();
    }

    public AuthManagementExcution(IndustryClassificationEnum industryClassificationEnum) {
        this.code = industryClassificationEnum.getCode();
    }
}
