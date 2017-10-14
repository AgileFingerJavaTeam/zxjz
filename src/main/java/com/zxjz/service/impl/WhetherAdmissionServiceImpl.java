package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.WhetherAdmissionDao;
import com.zxjz.dto.excution.WhetherAdmissionExcution;
import com.zxjz.dto.in.WhetherAdmissionDto;
import com.zxjz.enums.EnrollJobStatusEnum;
import com.zxjz.exception.WhetherAdmissionException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.WhetherAdmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Service
public class WhetherAdmissionServiceImpl implements WhetherAdmissionService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WhetherAdmissionDao whetherAdmissionDao;

    public WhetherAdmissionExcution whetherAdmission(WhetherAdmissionDto whetherAdmissionDto) {
        int student_user_id = whetherAdmissionDto.getStudent_user_id();
        int recruiting_id = whetherAdmissionDto.getRecruiting_id();
        String hired = whetherAdmissionDto.getHired();
        String after_confirmation = whetherAdmissionDto.getAfter_confirmation();
        try {
            if (hired == null || after_confirmation == null) {
                throw new WhetherAdmissionException("缺少参数");
            }
            if (!hired.equals("1") && !hired.equals("0")) {
                throw new WhetherAdmissionException("参数有误");
            }
            if (hired.equals("1")) {
                int whetherAdmiss = whetherAdmissionDao.updateAdmission(recruiting_id, student_user_id, hired, after_confirmation);
                if (whetherAdmiss > 0) {
                    return new WhetherAdmissionExcution(EnrollJobStatusEnum.HIRED_SUCCESS,null);
                } else {
                    throw new UpdateInnerErrorException("没有报名");
                }
            } else if (hired.equals("0")) {
                int whetherAdmiss = whetherAdmissionDao.updateAdmissionT(recruiting_id, student_user_id, hired);
                if (whetherAdmiss > 0) {
                    return new WhetherAdmissionExcution(EnrollJobStatusEnum.NO_HIRED_SUCCESS,null);
                } else {
                    throw new UpdateInnerErrorException("录取失败");
                }
            }
            throw new WhetherAdmissionException("未知错误");
        }catch (WhetherAdmissionException e1) {
            throw e1;
        }
        catch (UpdateInnerErrorException e2) {
            throw e2;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
