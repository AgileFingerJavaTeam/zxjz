package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StuJobDao;
import com.zxjz.dao.StuMsgDao;
import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.excution.StuMsgExcution;
import com.zxjz.dto.in.StuJobDto;
import com.zxjz.dto.in.StuMsgDto;
import com.zxjz.entity.StuJob;
import com.zxjz.entity.StuMsg;
import com.zxjz.enums.StuJobEnum;
import com.zxjz.enums.StuMsgEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.StuJobService;
import com.zxjz.service.StuMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StuMsgServiceImpl implements StuMsgService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StuMsgDao stuMsgDao;


    public StuMsgExcution stuMsg(StuMsgDto stuMsgDto) {
        int page = stuMsgDto.getPage();
        int rows = stuMsgDto.getRows();
        String bxw_search_content=stuMsgDto.getBxw_search_content();
        String start=stuMsgDto.getStart();
        String end=stuMsgDto.getEnd();
        try {
            if (bxw_search_content!=null){
                page=1;
                rows=20;
                if (bxw_search_content.equals("已读")){
                    bxw_search_content="是";
                }
                if (bxw_search_content.equals("未读")){
                    bxw_search_content="否";
                }
            }

            int offset = (page - 1) * rows;
            List<StuMsg> findStuMsg = stuMsgDao.findStuMsg(offset,rows,bxw_search_content,start,end);
            int total=stuMsgDao.findMsgNum(bxw_search_content,start,end);
            HashMap map=new HashMap();
            map.put("rows",findStuMsg);
            map.put("total",total);
            return new StuMsgExcution(StuMsgEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }

    public StuMsgExcution stuMsgStat(StuMsgDto stuMsgDto) {
        int user_id=stuMsgDto.getUser_id();
        try {
            int updateStat=stuMsgDao.updateStatus(user_id);
            if(updateStat>0){
                return  new StuMsgExcution(StuMsgEnum.SUCCESS);
            }else {
                throw new UpdateDatabaseException("更改状态失败");
            }
        } catch (UpdateDatabaseException u) {
            throw u;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
