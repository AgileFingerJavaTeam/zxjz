package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.MarchantArrearDao;
import com.zxjz.dto.excution.MarchantArrearExcution;
import com.zxjz.dto.in.MarchantArrearDto;
import com.zxjz.entity.MarchantArrear;
import com.zxjz.enums.MarchantArrearEnum;
import com.zxjz.service.MarchantArrearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
@Service
public class MarchantArrearServiceImpl implements MarchantArrearService{
    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MarchantArrearDao marchantArrearDao;

    public MarchantArrearExcution findMarchantArrear(MarchantArrearDto marchantArrearDto) {
        try {
            String at_search = marchantArrearDto.getAt_search();
            int page = (marchantArrearDto.getPage() != 0) ? marchantArrearDto.getPage() :1;
            int rows = (marchantArrearDto.getRows() !=0) ? marchantArrearDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<MarchantArrear> listName = marchantArrearDao.findMarchantArrear(at_search,offset,rows);
            int total = marchantArrearDao.findCarouselListCount(at_search);
            HashMap map = new HashMap();
            map.put("rows",listName);
            map.put("total", total);
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution getMarchantListSearch(MarchantArrearDto marchantArrearDto) {
        try {
            String at_search = marchantArrearDto.getAt_search();
            int page = (marchantArrearDto.getPage() != 0) ? marchantArrearDto.getPage() :1;
            int rows = (marchantArrearDto.getRows() !=0) ? marchantArrearDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<MarchantArrear> listName = marchantArrearDao.findMarchantArrearSearch(at_search,offset,rows);
            int total = marchantArrearDao.findCarouselListCount(at_search);
            HashMap map = new HashMap();
            map.put("rows",listName);
            map.put("total", total);
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution getReceivablesListSearch(MarchantArrearDto marchantArrearDto) {
        try {
            int userId = marchantArrearDto.getId();
            String at_searchs = marchantArrearDto.getAt_searchs();
            int page = (marchantArrearDto.getPage() != 0) ? marchantArrearDto.getPage() :1;
            int rows = (marchantArrearDto.getRows() !=0) ? marchantArrearDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<MarchantArrear> listName = marchantArrearDao.getReceivablesListSearch(at_searchs,offset,rows,userId);
            int total = marchantArrearDao.findCarouselListCountU(at_searchs,userId);
            HashMap map = new HashMap();
            map.put("rows",listName);
            map.put("total", total);
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution findCountQ() {
        try {
          int total = marchantArrearDao.findCarouselListCount3();
          return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS,total);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution findMoneyQ() {
        try {
            MarchantArrear total2 = marchantArrearDao.findCarouselListCount4();
           double querySumActual =total2.getQuerySumActual();
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS,querySumActual);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution findVipCount() {
        try {
            int countVip = marchantArrearDao.findCarouselListCount5();
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS,countVip);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution findVipCountMoney() {
        try {
            MarchantArrear total3 = marchantArrearDao.findCarouselListCount6();
            double sumCreditTotal =total3.getSumCreditTotal();
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS,sumCreditTotal);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution findSecurity(MarchantArrearDto marchantArrearDto) {
        try {
                int userId = marchantArrearDto.getId();
                MarchantArrear marchantArrear = marchantArrearDao.findSecurity(userId);
                return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS, marchantArrear);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public MarchantArrearExcution getReceivables(MarchantArrearDto marchantArrearDto) {
        try {
            int userId = marchantArrearDto.getId();
            String at_searchs = marchantArrearDto.getAt_searchs();
            int page = (marchantArrearDto.getPage() != 0) ? marchantArrearDto.getPage() :1;
            int rows = (marchantArrearDto.getRows() !=0) ? marchantArrearDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<MarchantArrear> marchantArrear = marchantArrearDao.getReceivablesList(at_searchs,offset,rows,userId);
            int total = marchantArrearDao.findCarouselListCount2(at_searchs,userId);
            HashMap map = new HashMap();
            map.put("rows",marchantArrear);
            map.put("total",total);
            return new MarchantArrearExcution(MarchantArrearEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
