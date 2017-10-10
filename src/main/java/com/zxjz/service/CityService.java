package com.zxjz.service;

import com.zxjz.dto.excution.CityExcution;
import com.zxjz.entity.City;

import java.util.List;

public interface CityService {
    /**
     * 获取城市列表
     * @return
     */

    public CityExcution getCity();
}
