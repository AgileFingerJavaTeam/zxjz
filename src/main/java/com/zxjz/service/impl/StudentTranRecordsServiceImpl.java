package com.zxjz.service.impl;

import com.zxjz.dao.StudentTranRecordsDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.StudentTranRecordsExcution;
import com.zxjz.dto.in.StudentTranRecordsDto;
import com.zxjz.entity.StudentTranRecords;
import com.zxjz.enums.CityEnum;
import com.zxjz.service.StudentTranRecordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTranRecordsServiceImpl implements StudentTranRecordsService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public StudentTranRecordsDao studentTranRecordsDao;

    public StudentTranRecordsExcution getStudentTranRecords(StudentTranRecordsDto studentTranRecordsDto) {
        int merchant_user_id = studentTranRecordsDto.getMerchant_user_id();
        int college_user_id = studentTranRecordsDto.getCollege_user_id();
        List<StudentTranRecords> getStudentTranRecords = studentTranRecordsDao.getStudentTranRecordsList(merchant_user_id, college_user_id);
        return new StudentTranRecordsExcution(getStudentTranRecords,CityEnum.FIND_SUCCESS);
    }
}
