package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.IndustryClassificationEnum;

public class StarEnterpriseLoGoExcution extends BaseAPIExcution{
    public StarEnterpriseLoGoExcution(Object data, IndustryClassificationEnum industryClassificationEnum) {
        this.data = data;
        this.code = industryClassificationEnum.getCode();
    }

    public StarEnterpriseLoGoExcution(IndustryClassificationEnum industryClassificationEnum) {
        this.code = industryClassificationEnum.getCode();
    }
}
