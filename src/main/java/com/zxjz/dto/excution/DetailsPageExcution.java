package com.zxjz.dto.excution;

import com.zxjz.enums.CityEnum;
import java.util.Map;

public class DetailsPageExcution {
    private Map map;
    private int code;
    private String codeInfo;

    public DetailsPageExcution(Map map, CityEnum cityEnum) {
        this.map = map;
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public DetailsPageExcution(CityEnum cityEnum) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
        return "DetailsPageExcution{" +
                "map=" + map +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
