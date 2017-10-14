package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.StationInfo;
import com.zxjz.enums.StationInfoEnum;
import com.zxjz.util.PageData;

import java.util.List;

public class StationInfoExcution extends BaseAPIExcution{



    public StationInfoExcution(StationInfoEnum stationInfoEnum) {
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum,Object data) {
        this.data = data;
        this.code = stationInfoEnum.getCode();
    }
}
