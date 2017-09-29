package com.zxjz.service.impl;

import com.zxjz.dao.WhetherAdmissionDao;
import com.zxjz.dto.excution.WhetherAdmissionExcution;
import com.zxjz.dto.in.WhetherAdmissionDto;
import com.zxjz.enums.EnrollJobStatusEnum;
import com.zxjz.service.WhetherAdmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Service
public class WhetherAdmissionServiceImpl implements WhetherAdmissionService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WhetherAdmissionDao whetherAdmissionDao;

    public WhetherAdmissionExcution whetherAdmission(WhetherAdmissionDto whetherAdmissionDto) {
               int student_user_id = whetherAdmissionDto.getStudent_user_id();
               int recruiting_id = whetherAdmissionDto.getRecruiting_id();
               String hired = whetherAdmissionDto.getHired();
               String after_confirmation = whetherAdmissionDto.getAfter_confirmation();
           if(hired == null || after_confirmation == null){
               return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_PRAM);
           }
           if(!hired.equals("1") && !hired.equals("0")){
               return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_DATA);
           }
           if(hired.equals("1")){
             int whetherAdmiss = whetherAdmissionDao.updateAdmission(recruiting_id,student_user_id,hired,after_confirmation);
           if(whetherAdmiss>0){
               return new WhetherAdmissionExcution(EnrollJobStatusEnum.HIRED_SUCCESS);
           }else{
               return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_SIGNUP);
           }
           }else if(hired.equals("0")){
             int whetherAdmiss = whetherAdmissionDao.updateAdmissionT(recruiting_id,student_user_id,hired);
             if(whetherAdmiss>0){
                 return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_HIRED_SUCCESS);
             }else{
                 return new WhetherAdmissionExcution(EnrollJobStatusEnum.HIRED_FAIL);
             }
           }
                return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_PRAM);
    }
}
