package com.zxjz.service.impl;

import com.zxjz.dao.ConfirmRejectionDao;
import com.zxjz.dto.excution.ConfirmRejectionExcution;
import com.zxjz.dto.in.ConfirmRejectionDto;
import com.zxjz.entity.ConfirmRejection;
import com.zxjz.enums.ConfirmRejectionEnum;
import com.zxjz.exception.RecruitmentNumEnoughEception;
import com.zxjz.exception.UpdateRecruitmentHiredException;
import com.zxjz.exception.UpdateRecruitmentNumExcepyion;
import com.zxjz.service.ConfirmRejectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmRejectionServiceImpl implements ConfirmRejectionService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ConfirmRejectionDao confirmRejectionDao;

    public ConfirmRejectionExcution updateConReject(ConfirmRejectionDto confirmRejectionDto) {
        String hired = confirmRejectionDto.getHired();
        int recruiting_id = confirmRejectionDto.getRecruiting_id();
        if (hired.equals("否")){
            int updateConReject = confirmRejectionDao.updateConReject(recruiting_id);
            if (updateConReject > 0) {
                return new ConfirmRejectionExcution(ConfirmRejectionEnum.REJECT_SUCCESS);
            }else{
                throw new UpdateRecruitmentHiredException("更新招聘信息的录用状态失败");
            }
        }
        if(hired.equals("是")){
            ConfirmRejection confirmRejection = confirmRejectionDao.getConRejectNum(recruiting_id);
            String employedNumber = confirmRejection.getEmployedNumber();
            int employedNum = Integer.parseInt(employedNumber);
            String recruitment = confirmRejection.getRecruitment();
            int recruitmentNum = Integer.parseInt(recruitment);
            if (recruitmentNum > employedNum){
                int updataEmployTime = confirmRejectionDao.updataEmployTime(recruiting_id);
                if (updataEmployTime <= 0) {
                    throw new UpdateRecruitmentHiredException("更新招聘信息的录用状态失败");
                }
                int findRecruId = confirmRejectionDao.findRecruId(recruiting_id);
                int updateNum = confirmRejectionDao.updateNum(findRecruId);
                if (updateNum <= 0){
                    throw new UpdateRecruitmentNumExcepyion("更新招聘信息的招聘人数失败");
                }
                return new ConfirmRejectionExcution(ConfirmRejectionEnum.HIRED_SUCCESS);
            }
            throw new RecruitmentNumEnoughEception("该职位人数已满");
        }
        return  null;
    }
}
