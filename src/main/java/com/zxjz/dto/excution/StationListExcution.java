package com.zxjz.dto.excution;

import com.zxjz.entity.ManagementPart;
import com.zxjz.entity.StationList;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class StationListExcution {

    private List<StationList> stationList;
    private int code;
    private String codeInfo;

    public StationListExcution(List<StationList> stationList, StuPersonalEnum stuPersonalEnum) {
        this.stationList = stationList;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public StationListExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public List<StationList> getStationList() {
        return stationList;
    }

    public void setStationList(List<StationList> stationList) {
        this.stationList = stationList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "StationListExcution{" +
                "stationList=" + stationList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
