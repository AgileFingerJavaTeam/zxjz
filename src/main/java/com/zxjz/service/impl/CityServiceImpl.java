package com.zxjz.service.impl;

import com.zxjz.dao.CityDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.entity.City;
import com.zxjz.enums.CityEnum;
import com.zxjz.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CityDao cityDao;


    public CityExcution getCity() {
          List<City> cityList =cityDao.getCityList();
          return new CityExcution(CityEnum.FIND_SUCCESS,cityList);
    }
}
