package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.AtMarchantFindDao;
import com.zxjz.dto.excution.AtMarchantFindExcution;
import com.zxjz.dto.in.AtMarchantFindDto;
import com.zxjz.entity.AtMarchantFind;
import com.zxjz.enums.AtMarchantFindEnum;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.AtMarchantFindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Service
public class AtMarchantFindServiceImpl implements AtMarchantFindService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AtMarchantFindDao atMarchantFindDao;

    public AtMarchantFindExcution getMarchantList(AtMarchantFindDto atMarchantFindDto) {
        try {
            String at_marchant_search = atMarchantFindDto.getAt_marchant_search();
            int page = (atMarchantFindDto.getPage() != 0) ? atMarchantFindDto.getPage() :1;
            int rows = (atMarchantFindDto.getRows() !=0) ? atMarchantFindDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<AtMarchantFind> listName = atMarchantFindDao.getMarchantList(offset,rows,at_marchant_search);
            int total = atMarchantFindDao.findCarouselListCount(at_marchant_search);
            HashMap map = new HashMap();
            map.put("rows",listName);
            map.put("total", total);
            return new AtMarchantFindExcution(AtMarchantFindEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public AtMarchantFindExcution getMarchantIsLook(AtMarchantFindDto atMarchantFindDto) {
        try {
            int id = atMarchantFindDto.getId();
            AtMarchantFind atMarchantFind = atMarchantFindDao.getMarchantIsLook(id);
            return new AtMarchantFindExcution(AtMarchantFindEnum.SUCCESS, atMarchantFind);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public AtMarchantFindExcution editMarchant(AtMarchantFindDto atMarchantFindDto) {
        try {
             int id = atMarchantFindDto.getId();
             int editMarchant = atMarchantFindDao.editMarchant(id);
             if(editMarchant > 0 ){
                 return new AtMarchantFindExcution(AtMarchantFindEnum.SUCCESS,null);
             }else{
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

    public AtMarchantFindExcution getMarchantListTimeSearch(AtMarchantFindDto atMarchantFindDto) {
        try {
            String start_time = atMarchantFindDto.getStart_time();
            String end_time = atMarchantFindDto.getEnd_time();
            String at_marchant_search = atMarchantFindDto.getAt_marchant_search();
            int page = (atMarchantFindDto.getPage() != 0) ? atMarchantFindDto.getPage() :1;
            int rows = (atMarchantFindDto.getRows() !=0) ? atMarchantFindDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<AtMarchantFind> listName = atMarchantFindDao.getMarchantListTimeSearch(offset,rows,at_marchant_search,start_time,end_time);
            int total = atMarchantFindDao.findCarouselListCount2(at_marchant_search,start_time,end_time);
            HashMap map = new HashMap();
            map.put("rows",listName);
            map.put("total", total);
            return new AtMarchantFindExcution(AtMarchantFindEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
