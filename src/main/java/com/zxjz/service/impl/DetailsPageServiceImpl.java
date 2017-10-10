package com.zxjz.service.impl;

import com.zxjz.dao.BillListDao;
import com.zxjz.dao.DetailsPageDao;
import com.zxjz.dto.excution.ConfirmRejectionExcution;
import com.zxjz.dto.excution.DetailsPageExcution;
import com.zxjz.dto.in.DetailsPageDto;
import com.zxjz.entity.DetailsPage;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.ConfirmRejectionEnum;
import com.zxjz.service.DetailsPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DetailsPageServiceImpl implements DetailsPageService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public DetailsPageDao detailsPageDao;

    public DetailsPageExcution getDetailsPage(DetailsPageDto detailsPageDto) {
        int id = detailsPageDto.getId();
        int user_id = detailsPageDto.getUser_id();
        int work_id = detailsPageDto.getWork_id();
        Map map = new HashMap();
        DetailsPage detailsPage = detailsPageDao.getDetailsPage(id);
        int getCommentariesNum = detailsPageDao.getCommentariesNum(user_id);
        String getIsOver = detailsPageDao.getIsOver(work_id);
        map.put("detailsPage", detailsPage);
        map.put("getCommentariesNum", getCommentariesNum);
        map.put("getIsOver", getIsOver);
        return new DetailsPageExcution(map, CityEnum.FIND_SUCCESS);
    }
}
