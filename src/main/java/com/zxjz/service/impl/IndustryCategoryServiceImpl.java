package com.zxjz.service.impl;

import com.zxjz.dao.IndustryCategoryDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.IndustryCategoryExcution;
import com.zxjz.entity.IndustryCategory;
import com.zxjz.enums.CityEnum;
import com.zxjz.service.IndustryCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryCategoryServiceImpl implements IndustryCategoryService {

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public IndustryCategoryDao industryCategoryDao;

    public IndustryCategoryExcution getIndustryCategory() {
        List<IndustryCategory> getIndustryCategoryList = industryCategoryDao.getIndustryCategoryList();
        return new IndustryCategoryExcution(getIndustryCategoryList,CityEnum.FIND_SUCCESS);
    }
}
