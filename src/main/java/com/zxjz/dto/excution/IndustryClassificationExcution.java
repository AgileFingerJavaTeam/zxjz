package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.IndustryClassification;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.IndustryClassificationEnum;

import java.util.List;

public class IndustryClassificationExcution extends BaseAPIExcution{

    public IndustryClassificationExcution(Object data, IndustryClassificationEnum industryClassificationEnum) {
        this.data = data;
        this.code = industryClassificationEnum.getCode();
    }

    public IndustryClassificationExcution(IndustryClassificationEnum industryClassificationEnum) {
        this.code = industryClassificationEnum.getCode();
    }

}
