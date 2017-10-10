package com.zxjz.service.impl;

import com.zxjz.dao.PendingTreatmentDao;
import com.zxjz.dto.excution.PendingTreatmentExcution;
import com.zxjz.dto.in.PendingTreatmentDto;
import com.zxjz.entity.PendingTreatment;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.PendingTreatmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendingTreatmentServiceImpl implements PendingTreatmentService {

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PendingTreatmentDao pendingTreatmentDao;

    public PendingTreatmentExcution findPendingTreatment(PendingTreatmentDto pendingTreatmentDto) {
        int which = pendingTreatmentDto.getWhich();
        int user_id = pendingTreatmentDto.getUser_id();
        List<PendingTreatment> findPendingTreatmentList = pendingTreatmentDao.getPendingTreatmentList(which, user_id);
        for (int i = 0; i < findPendingTreatmentList.size(); i++){
            PendingTreatment pend = findPendingTreatmentList.get(i);
            int college_user_id = pend.getCollegeUserId();
            int work_id = pend.getWorkId();
            String getPartNum = pendingTreatmentDao.getPartNum(college_user_id);
            Double getAccumulatedMoney = pendingTreatmentDao.getAccumulatedMoney(work_id);
            pend.setNumberJob(getPartNum);
            pend.setMoneyAmount(getAccumulatedMoney);
        }
        return new PendingTreatmentExcution(findPendingTreatmentList, StuPersonalEnum.FIND_SUCCESS);
    }
}
