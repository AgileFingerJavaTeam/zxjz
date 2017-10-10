package com.zxjz.dao;

import com.zxjz.entity.City;

import java.util.List;

public interface CityDao {
    /**
     * 查询城市列表
     * @param
     * @return
     */
    public List<City> getCityList();
}
