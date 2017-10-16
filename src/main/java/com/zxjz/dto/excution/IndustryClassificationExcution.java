package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CityEnum;


public class IndustryClassificationExcution extends BaseAPIExcution{

    public IndustryClassificationExcution(Object data, CityEnum cityEnum) {
        this.data = data;
        this.code = cityEnum.getCode();
    }

}
