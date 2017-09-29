package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StudentRegistrationDao;
import com.zxjz.dto.excution.StudentRegistrationExcution;
import com.zxjz.dto.in.StudentRegistrationDto;
import com.zxjz.entity.StudentRegistration;
import com.zxjz.enums.EnrollJobStatusEnum;
import com.zxjz.service.StudentRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentRegistrationDao studentRegistrationDao;
    public StudentRegistrationExcution studentRegistration(StudentRegistrationDto studentRegistrationDto) {
                int recruit_id = studentRegistrationDto.getRecruit_id();
                int user_id = studentRegistrationDto.getUser_id();
                int work_id = studentRegistrationDto.getWork_id();
        try {
            StudentRegistration studentRegistration = studentRegistrationDao.findStudentRegistration(work_id,recruit_id,user_id);
            if(studentRegistration == null){
                return new StudentRegistrationExcution(EnrollJobStatusEnum.STUDENT_EDIT_FAIL);
            }else{
                return new StudentRegistrationExcution(EnrollJobStatusEnum.STUDENT_EDIT_SUCCESS,studentRegistration);
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
