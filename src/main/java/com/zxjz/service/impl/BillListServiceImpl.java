package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.BillListDao;
import com.zxjz.dto.excution.BillListExcution;
import com.zxjz.dto.in.BillListDto;
import com.zxjz.entity.BillList;
import com.zxjz.enums.StuPersonalEnum;
import com.zxjz.service.BillListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillListServiceImpl implements BillListService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BillListDao billListDao;

    public BillListExcution getBillList(BillListDto billListDto) {
        int work_id = billListDto.getWork_id();
        int college_user_id = billListDto.getCollege_user_id();
        int recruiting_id = billListDto.getRecruiting_id();
        try {
            List<BillList> billLists = billListDao.getBillList(work_id, college_user_id, recruiting_id);
            return new BillListExcution(billLists, StuPersonalEnum.FIND_SUCCESS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}

