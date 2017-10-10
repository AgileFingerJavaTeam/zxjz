package com.zxjz.dto.excution;

import com.zxjz.entity.City;
import com.zxjz.enums.CityEnum;

import java.util.List;

public class CityExcution{

    private List<City> listCity;
    private int code;
    private String codeInfo;

    public CityExcution(CityEnum cityEnum) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
    }

    public CityExcution(CityEnum cityEnum,List<City> listCity) {
        this.code = cityEnum.getCode();
        this.codeInfo = cityEnum.getCodeInfo();
        this.listCity = listCity;
    }

    public List<City> getListCity() {
        return listCity;
    }

    public void setListCity(List<City> listCity) {
        this.listCity = listCity;
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
        return "CityExcution{" +
                "listCity=" + listCity +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
