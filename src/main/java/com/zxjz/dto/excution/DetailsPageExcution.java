package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CityEnum;
import java.util.Map;

public class DetailsPageExcution extends BaseAPIExcution{

    public DetailsPageExcution(Map map, CityEnum cityEnum) {
        this.data = map;
        this.code = cityEnum.getCode();
    }

    public DetailsPageExcution(String errorInfo, CityEnum cityEnum) {
        this.data = errorInfo;
        this.code = cityEnum.getCode();
    }

}
