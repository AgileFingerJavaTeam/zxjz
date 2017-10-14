package com.zxjz.dto.excution;

import com.zxjz.entity.StationInfo;
import com.zxjz.enums.StationInfoEnum;
import com.zxjz.util.PageData;

import java.util.List;

public class StationInfoExcution {
    private int code;
    private int count;
    private String parentJobName;
    private StationInfo stationInfo;
    private List<StationInfo> stationInfoList;
    private List<PageData> pageDataList;

    public StationInfoExcution(StationInfoEnum stationInfoEnum) {
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum,int parentJobCount) {
        this.count = parentJobCount;
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum,StationInfo stationInfo) {
        this.stationInfo = stationInfo;
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum,List<StationInfo> stationInfoList,int count) {
        this.count = count;
        this.stationInfoList = stationInfoList;
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum, List<PageData> pageDataList) {
        this.pageDataList = pageDataList;
        this.code = stationInfoEnum.getCode();
    }
    public StationInfoExcution(StationInfoEnum stationInfoEnum, StationInfo stationInfo,String parentJobName) {
        this.parentJobName = parentJobName;
        this.stationInfo = stationInfo;
        this.code = stationInfoEnum.getCode();
    }
}
