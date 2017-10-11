package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.HomepageRecommendDao;
import com.zxjz.dto.excution.HomepageRecommendExcution;
import com.zxjz.dto.in.HomepageRecommendDto;
import com.zxjz.enums.HomepageRecommendEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.HomepageRecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Service
public class HomepageRecommendServiceImpl implements HomepageRecommendService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HomepageRecommendDao homepageRecommendDao;
    public HomepageRecommendExcution updateOrHomepageRecommend(HomepageRecommendDto homepageRecommendDto) {
                  int recruiting_id = homepageRecommendDto.getRecruiting_id();
                  String hzn_recommend_begin_time = homepageRecommendDto.getHzn_recommend_begin_time();
                  String hzn_recommend_end_time =  homepageRecommendDto.getHzn_recommend_end_time();
            try{
                  int flag = (int)homepageRecommendDao.updateORHomepageRecommend(recruiting_id,hzn_recommend_begin_time,hzn_recommend_end_time);
                  if (flag>0) {
                        return new HomepageRecommendExcution(HomepageRecommendEnum.UPDATE_JOB_STATUS_SUCCESS);
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

    public HomepageRecommendExcution updateCloseHomepageRecommend(HomepageRecommendDto homepageRecommendDto) {
        int recruiting_id = homepageRecommendDto.getRecruiting_id();
        try{
            int flag = (int)homepageRecommendDao.updateDownHomepageRecommend(recruiting_id);
            if (flag>0) {
                return new HomepageRecommendExcution(HomepageRecommendEnum.UPDATE_JOB_STATUS_SUCCESS);
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
