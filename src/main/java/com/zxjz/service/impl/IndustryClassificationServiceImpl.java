package com.zxjz.service.impl;

import com.zxjz.dao.IndustryClassificationDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.IndustryClassificationExcution;
import com.zxjz.entity.IndustryClassification;
import com.zxjz.enums.CityEnum;
import com.zxjz.service.IndustryClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndustryClassificationServiceImpl implements IndustryClassificationService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public IndustryClassificationDao industryClassificationDao;

    public IndustryClassificationExcution findListIndustryClassification() {
        List<IndustryClassification> findListIndustryClassification = industryClassificationDao.getListIndustryClassification();
        return new IndustryClassificationExcution(findListIndustryClassification,CityEnum.FIND_SUCCESS);
    }
}
