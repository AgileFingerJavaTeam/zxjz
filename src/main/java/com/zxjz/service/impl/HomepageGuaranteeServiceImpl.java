package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.HomepageGuaranteeDao;
import com.zxjz.dto.excution.HomepageGuaranteeExcution;
import com.zxjz.dto.in.HomepageGuaranteeDto;
import com.zxjz.enums.HomepageGuaranteeEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.HomepageGuaranteeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Service
public class HomepageGuaranteeServiceImpl implements HomepageGuaranteeService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HomepageGuaranteeDao homepageGuaranteeDao;

    public HomepageGuaranteeExcution updateOrDownHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto) {
                  int recruiting_id = homepageGuaranteeDto.getRecruiting_id();
                  String hzn_good_begin_time = homepageGuaranteeDto.getHzn_good_begin_time();
                  String hzn_good_end_time = homepageGuaranteeDto.getHzn_good_end_time();
            try{
                int flag = (int)homepageGuaranteeDao.updateOrDownHomepageGuarantee(recruiting_id,hzn_good_begin_time,hzn_good_end_time);
                if (flag>0) {
                    return new HomepageGuaranteeExcution(HomepageGuaranteeEnum.UPDATE_JOB_STATUS_SUCCESS);
                }else {
                    throw new UpdateInnerErrorException("更改失败");
                }
            }catch (UpdateInnerErrorException e1) {
                throw e1;
            }
             catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new BaseException(e.getMessage());
            }
    }

    public HomepageGuaranteeExcution updatedownHomepageGuarantee(HomepageGuaranteeDto homepageGuaranteeDto) {
                int recruiting_id = homepageGuaranteeDto.getRecruiting_id();
        try{
            int flag = (int)homepageGuaranteeDao.updatedownHomepageGuarantee(recruiting_id);
            if (flag>0) {
                return new HomepageGuaranteeExcution(HomepageGuaranteeEnum.UPDATE_JOB_STATUS_SUCCESS);
            }else {
                throw new UpdateInnerErrorException("更改失败");
            }
        }catch (UpdateInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
