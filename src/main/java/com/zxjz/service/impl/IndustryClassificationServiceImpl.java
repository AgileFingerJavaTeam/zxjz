package com.zxjz.service.impl;

import com.zxjz.dao.IndustryClassificationDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.IndustryClassificationExcution;
import com.zxjz.dto.in.IndustryClassificationDto;
import com.zxjz.entity.IndustryCategory;
import com.zxjz.entity.IndustryClassification;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.IndustryClassificationEnum;
import com.zxjz.service.IndustryClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndustryClassificationServiceImpl implements IndustryClassificationService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public IndustryClassificationDao industryClassificationDao;

    /**
     * 查询参数信息
     * @return
     */
    public IndustryClassificationExcution findListIndustryClassification() {
        List<IndustryClassification> findListIndustryClassification = industryClassificationDao.getListIndustryClassification();
        int total = industryClassificationDao.total();
        Map map = new HashMap();
        map.put("rows",findListIndustryClassification);
        map.put("total",total);
        return new IndustryClassificationExcution(map,IndustryClassificationEnum.FIND_SUCCESS);
    }

    /**
     * 添加行业信息
     * @param industryClassificationDto
     * @return
     */
    public IndustryClassificationExcution insertIndustry(IndustryClassificationDto industryClassificationDto) {
        String name = industryClassificationDto.getName();
        int insertIndustry = industryClassificationDao.insertIndustry(name);
        if (insertIndustry > 0){
            return new IndustryClassificationExcution(IndustryClassificationEnum.RETURN_SUCCESS);
        }else{
            return new IndustryClassificationExcution(IndustryClassificationEnum.RETURN_FAIL);
        }
    }

    /**
     * 编辑行业信息
     * @param industryClassificationDto
     * @return
     */
    public IndustryClassificationExcution editIndustry(IndustryClassificationDto industryClassificationDto) {
        String name = industryClassificationDto.getName();
        int value = industryClassificationDto.getValue();
        int editIndustry = industryClassificationDao.editIndustry(name,value);
        if (editIndustry > 0){
            return new IndustryClassificationExcution(IndustryClassificationEnum.UPDATE_SUCCESS);
        }else {
            return new IndustryClassificationExcution(IndustryClassificationEnum.UPDATE_FAIL);
        }
    }

    /**
     * 删除行业信息
     * @param industryClassificationDto
     * @return
     */
    public IndustryClassificationExcution updateIndustry(IndustryClassificationDto industryClassificationDto) {
        int value = industryClassificationDto.getValue();
        int updateIndustry = industryClassificationDao.updateIndustry(value);
        if (updateIndustry > 0){
            return new IndustryClassificationExcution(IndustryClassificationEnum.UPDATE_SUCCESS);
        }else {
            return new IndustryClassificationExcution(IndustryClassificationEnum.UPDATE_FAIL);
        }
    }

    public IndustryClassificationExcution findIndustryCategory(IndustryClassificationDto industryClassificationDto) {
        int value = industryClassificationDto.getValue();
        IndustryCategory findIndustryCategory = industryClassificationDao.findIndustryCategory(value);
        if (findIndustryCategory == null){
            return new IndustryClassificationExcution(IndustryClassificationEnum.FIND_ERROR);
        }else {
            return new IndustryClassificationExcution(findIndustryCategory,IndustryClassificationEnum.FIND_SUCCESS);
        }
    }
}
