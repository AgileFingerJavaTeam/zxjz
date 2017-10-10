package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class CityList {
    private int cityId;//城市ID
    private String cityName;//城市名称

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityList{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
