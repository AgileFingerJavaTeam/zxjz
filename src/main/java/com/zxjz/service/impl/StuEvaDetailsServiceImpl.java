package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StuEvaDetailsDao;
import com.zxjz.dto.excution.StuEvaDetailsExcution;
import com.zxjz.dto.excution.StuPersonalExcution;
import com.zxjz.dto.in.StuEvaDetailsDto;
import com.zxjz.dto.in.StuPersonalDto;
import com.zxjz.entity.StuEvaDetails;
import com.zxjz.entity.StuPersonal;
import com.zxjz.enums.StuPersonalEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuEvaDetailsServiceImpl {

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StuEvaDetailsDao stuEvaDetailsDao;

    public StuPersonalExcution findStuPersonal(StuPersonalDto stuPersonalDto) {
        int userID = stuPersonalDto.getUserID();
        try{
            StuPersonal stuPersonal = stuEvaDetailsDao.getStuPersonal(userID);
            if (stuPersonal != null) {
                return new StuPersonalExcution(stuPersonal,StuPersonalEnum.FIND_SUCCESS);
            }else{
                return new StuPersonalExcution(null,StuPersonalEnum.FIND_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }


    public StuEvaDetailsExcution findStuEvaDetails(StuEvaDetailsDto stuEvaDetailsDto) {
        int userID = stuEvaDetailsDto.getUserID();
        try{
            StuEvaDetails stuEvaDetails = stuEvaDetailsDao.getStuEvaDetails(userID);
            if (stuEvaDetails != null) {
                return new StuEvaDetailsExcution(stuEvaDetails, StuPersonalEnum.FIND_SUCCESS);
            }else{
                return new StuEvaDetailsExcution(null,StuPersonalEnum.FIND_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
