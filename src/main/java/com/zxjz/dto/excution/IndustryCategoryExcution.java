package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.IndustryCategory;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class IndustryCategoryExcution extends BaseAPIExcution{

    public IndustryCategoryExcution(List<IndustryCategory> getIndustryCategoryList, CityEnum cityEnum) {
        this.data = getIndustryCategoryList;
        this.code = cityEnum.getCode();
    }

}
