package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.SettlementDao;
import com.zxjz.dto.excution.SettlementExcution;
import com.zxjz.dto.in.SettlementDto;
import com.zxjz.entity.Settlement;
import com.zxjz.enums.SettlementEnum;
import com.zxjz.service.SettlementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@Service
public class SettlementServiceImpl implements SettlementService {
    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SettlementDao settlementDao;


    public SettlementExcution findListSettlement(SettlementDto settlementDto) {
            String search = settlementDto.getSearch();
            int rows = settlementDto.getRows();
            int page = settlementDto.getPage();
            int offset=(page-1)*rows;
       try{
           List<Settlement> infoList=settlementDao.findListSettlement(rows,offset);
           int total = settlementDao.findSettlementCount(search);
           SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
           if (infoList != null) {
               for (Settlement mer : infoList) {
                   String settle = mer.getSettlementTime();
                   if(settle != null){
                       Date date = fmt.parse(settle);
                       String apply = fmt.format(date);
                       mer.setSettlementTime(apply);
                   }
               }
           }
           return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,infoList,total);
       } catch (Exception e) {
           logger.error(e.getMessage(), e);
           throw new BaseException(e.getMessage());
       }
    }

    public SettlementExcution findSearch(SettlementDto settlementDto) {
            String search = settlementDto.getSearch();
            int rows = settlementDto.getRows();
            int page = settlementDto.getPage();
            int offset=(page-1)*rows;
        try{
            List<Settlement> infoList=settlementDao.findSearch(rows,offset,search);
            int total = settlementDao.findSettlementCount(search);
            return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,infoList,total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SettlementExcution getSettlementData(SettlementDto settlementDto) {
             int id = settlementDto.getId();
             int ob = settlementDto.getOb();
             int uid = settlementDto.getUid();
        try{
            Settlement settlement=settlementDao.getSettlementData(id,ob,uid);
            return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,settlement);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SettlementExcution findMaxNumber(SettlementDto settlementDto) {
              int id = settlementDto.getId();
              HashMap map =new HashMap();
        try{
            Map info=settlementDao.findMaxNumber(id);
            map.put("data", info);
            if (info == null){
                String withlist = "0";
                return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,withlist);
            }else{
                return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,info);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public SettlementExcution findMerchantsName(SettlementDto settlementDto) {
        String q = settlementDto.getQ();
        String search = settlementDto.getSearch();
        int rows = settlementDto.getRows();
        int page = settlementDto.getPage();
        int offset=(page-1)*rows;
        try{
            List<Settlement> infoList=settlementDao.findMerchantsName(rows,offset,q);
            int total = settlementDao.findSettlementCount(search);
            return new SettlementExcution(SettlementEnum.COLLECTION_SUCCESS,infoList,total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }



}
