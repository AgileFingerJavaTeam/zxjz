package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.ManagementPartDao;
import com.zxjz.dto.excution.ManagementPartExcuton;
import com.zxjz.dto.excution.UpdateIsOverExcution;
import com.zxjz.dto.excution.UpdatePauseExcution;
import com.zxjz.dto.excution.UpdateRejectExcution;
import com.zxjz.dto.in.ManagementPartDto;
import com.zxjz.dto.in.UpdatePauseDto;
import com.zxjz.dto.in.UpdateRejectDto;
import com.zxjz.entity.ManagementPart;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.enums.UpdatePauseEnum;
import com.zxjz.service.ManagementPartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementPartServiceImpl implements ManagementPartService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ManagementPartDao managementPartDao;

    /**
     * 获取职位管理
     * @param managementPartDto
     * @return
     */
    public ManagementPartExcuton findManagementPart(ManagementPartDto managementPartDto) {
        int userID = managementPartDto.getUserID();
        String recruitmentListType = managementPartDto.getRecruitmentListType();
        List<ManagementPart> List = null;
        try{
            if(recruitmentListType.equals(null)){
                return new ManagementPartExcuton(StuPersonalEnum.FIND_ERROR);
            }
            if (recruitmentListType.equals("0")){
                List<ManagementPart> underWayInfor = managementPartDao.getUnderWayInfor(userID);
                List<ManagementPart> toAudit = managementPartDao.getToAudit(userID);
                List<ManagementPart> hasBeenRejected = managementPartDao.getHasBeenRejected(userID);
                List = new ArrayList<ManagementPart>();
                List.addAll(underWayInfor);
                List.addAll(toAudit);
                List.addAll(hasBeenRejected);
                return new ManagementPartExcuton(List, StuPersonalEnum.FIND_SUCCESS);
            }else if (recruitmentListType.equals("1")){
                List = managementPartDao.getIsOver(userID);
                return new ManagementPartExcuton(List, StuPersonalEnum.FIND_SUCCESS);
            }else{
                List = managementPartDao.getDraftBox(userID);
                return new ManagementPartExcuton(List, StuPersonalEnum.FIND_SUCCESS);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 暂停
     * @param updatePauseDto
     * @return
     */
    public UpdatePauseExcution updatePause(UpdatePauseDto updatePauseDto) {
        int recruitingId = updatePauseDto.getRecruitingId();
        String recruitmentStatus = updatePauseDto.getRecruitmentStatus();
        int updatePause = 0;
        try {
            if (recruitmentStatus.equals("0")) {
                updatePause = managementPartDao.updatePause(recruitingId);
                return new UpdatePauseExcution(updatePause, UpdatePauseEnum.UPDATE_SUCCESS);
            } else if (recruitmentStatus.equals("1")) {
                updatePause = managementPartDao.updateFor(recruitingId);
                return new UpdatePauseExcution(updatePause, UpdatePauseEnum.UPDATE_SUCCESS);
            }
            return new UpdatePauseExcution(updatePause, UpdatePauseEnum.UPDATE_ERROR);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 审核驳回
     * @param updateRejectDto
     * @return
     */
    public UpdateRejectExcution updateReject(UpdateRejectDto updateRejectDto) {
        int recruitingId = updateRejectDto.getRecruitingId();
        try {
            int updateReject = managementPartDao.updateReject(recruitingId);
            return new UpdateRejectExcution(updateReject, UpdatePauseEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 结束
     * @param updateRejectDto
     * @return
     */
    public UpdateIsOverExcution updateIsOver(UpdateRejectDto updateRejectDto) {
        int recruitingId = updateRejectDto.getRecruitingId();
        try {
            int updateIsOver = managementPartDao.updateIsOver(recruitingId);
            return new UpdateIsOverExcution(updateIsOver, UpdatePauseEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
