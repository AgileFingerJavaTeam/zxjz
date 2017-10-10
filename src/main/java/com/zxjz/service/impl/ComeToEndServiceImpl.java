package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.ComeToEndDao;
import com.zxjz.dto.excution.ComeToEndExcution;
import com.zxjz.dto.in.ComeToEndDto;
import com.zxjz.enums.UpdatePauseEnum;
import com.zxjz.service.ComeToEndService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComeToEndServiceImpl implements ComeToEndService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ComeToEndDao comeToEndDao;

    public ComeToEndExcution updateComeToEnd(ComeToEndDto comeToEndDto) {
        int work_id = comeToEndDto.getWork_id();
        try {
            int updateComeToEnd = comeToEndDao.updateComeToEnd(work_id);
            return new ComeToEndExcution(updateComeToEnd, UpdatePauseEnum.UPDATE_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
