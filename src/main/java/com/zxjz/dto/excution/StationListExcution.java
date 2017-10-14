package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.ManagementPart;
import com.zxjz.entity.StationList;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class StationListExcution extends BaseAPIExcution{

    public StationListExcution(List<StationList> stationList, StuPersonalEnum stuPersonalEnum) {
        this.data = stationList;
        this.code = stuPersonalEnum.getCode();
    }

    public StationListExcution(String errorInfo, StuPersonalEnum stuPersonalEnum) {
        this.data = errorInfo;
        this.code = stuPersonalEnum.getCode();
    }

}
