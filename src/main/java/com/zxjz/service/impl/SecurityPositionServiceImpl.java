package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.SecurityPositionDao;
import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.SecurityPositionDto;
import com.zxjz.entity.AtCollection;
import com.zxjz.enums.SecurityPositionEnum;
import com.zxjz.service.SecurityPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Service
public class SecurityPositionServiceImpl implements SecurityPositionService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SecurityPositionDao securityPositionDao;

    public SecurityPositionExcution getSecurityPositionList(SecurityPositionDto securityPositionDto) {
            String statusSearch = securityPositionDto.getStatusSearch();
            String search = securityPositionDto.getSearch();
            int page=securityPositionDto.getPage();
            int rows=securityPositionDto.getRows();
            int offset=(page-1)*rows;
        try{

            List<AtCollection> list = securityPositionDao.findListCollection(offset,rows);
            int total = securityPositionDao.findSecurityPositionListCount(statusSearch,search);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
         if(list != null){
             for (AtCollection mer : list) {
                 String reBegin = mer.getRecommendBeginTime();
                 String reEnd = mer.getRecommendEndTime();
                 String begin = mer.getGoodBeginTime();
                 String end = mer.getGoodEndTime();
                 if(reBegin != null){
                     Date date = fmt.parse(reBegin);
                     String apply = fmt.format(date);
                     mer.setRecommendBeginTime(apply);
                 }
                 if(reEnd != null){
                     Date date = fmt.parse(reEnd);
                     String apply = fmt.format(date);
                     mer.setRecommendEndTime(apply);
                 }
                 if (begin != null) {
                     Date date = fmt.parse(begin);
                     String apply = fmt.format(date);
                     mer.setGoodBeginTime(apply);
                 }
                 if (end != null) {
                     Date date = fmt.parse(end);
                     String status = fmt.format(date);
                     mer.setGoodEndTime(status);
                 }
             }
         }
            return new SecurityPositionExcution(SecurityPositionEnum.COLLECTION_SUCCESS,list,total);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SecurityPositionExcution getSecurityPosition(SecurityPositionDto securityPositionDto) {
            int id = securityPositionDto.getId();
        try {
            AtCollection atCollection=securityPositionDao.findSecurityPositionSecurity(id);
            int post_calssification=atCollection.getPostClassification();
            Map map=securityPositionDao.findSecurityPositionSecurity1(post_calssification);
            return new SecurityPositionExcution(atCollection,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
