package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.City;
import com.zxjz.enums.CityEnum;

import java.util.List;

public class CityExcution extends BaseAPIExcution{

    public CityExcution(CityEnum cityEnum,List<City> listCity) {
        this.code = cityEnum.getCode();
        this.data = listCity;
    }

    public CityExcution(CityEnum cityEnum,String errorInfo) {
        this.code = cityEnum.getCode();
        this.data = errorInfo;
    }
}
