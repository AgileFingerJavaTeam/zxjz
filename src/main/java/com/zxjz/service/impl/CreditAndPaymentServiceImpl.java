package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.CityDao;
import com.zxjz.dao.CreditDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.CreditAndPaymentExcution;
import com.zxjz.dto.in.CreditAndPaymentDto;
import com.zxjz.entity.City;
import com.zxjz.entity.CreditAndPayment;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.CreditEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.CityService;
import com.zxjz.service.CreditAndPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CreditAndPaymentServiceImpl implements CreditAndPaymentService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CreditDao creditDao;

    public CreditAndPaymentExcution findList(CreditAndPaymentDto creditAndPaymentDto) {
        int rows=creditAndPaymentDto.getRows();
        String sort=creditAndPaymentDto.getSort();
        String order=creditAndPaymentDto.getOrder();
        String bxw_search_content=creditAndPaymentDto.getBxw_search_content();
        /*HashMap maps=new HashMap();
        maps.put("bxw_search_content",bxw_search_content);
        System.out.println(maps.toString());*/
        int page=creditAndPaymentDto.getPage();
        try{
            int offset = (page - 1) * rows;
            ArrayList<CreditAndPayment> findList = creditDao.findCreditList(bxw_search_content,sort,order,offset,rows);
            if(findList!=null) {
                for (int i = 0; i < findList.size(); i++) {
                    Double credit_total = findList.get(i).getCreditTotal();
                    Double credit_banance = findList.get(i).getCreditBalance();
                    if (credit_total == null) {
                        credit_total = (double) 0;
                    }
                    if (credit_banance == null) {
                        credit_banance = (double) 0;
                    }
                    Double debt = credit_total - credit_banance;
                    findList.get(i).setDebt(debt);
                    System.out.println(findList);
                }
                int total = creditDao.total(sort,order);
                HashMap map=new HashMap();
                map.put("rows",findList);
                map.put("total",total);
                return new CreditAndPaymentExcution(CreditEnum.SUCCESS,map);
            }   else{
                throw new QueryInnerErrorException ("查询失败");
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }

    public CreditAndPaymentExcution updateCredit(CreditAndPaymentDto creditAndPaymentDto) {
            int user_id=creditAndPaymentDto.getUser_id();
            try{
                CreditAndPayment info = creditDao.updateCredit(user_id);
                Double credit_total=info.getCreditTotal();
                Double credit_banance=info.getCreditBalance();
                if(credit_total==null){
                    credit_total=(double) 0;
                }
                if(credit_banance==null){
                    credit_banance=(double) 0;
                }
                Double debt=credit_total-credit_banance;
                info.setDebt(debt);
                return new CreditAndPaymentExcution(CreditEnum.UPDATE_SUCCESS,info);
            }catch (Exception e){
                logger.error(e.getMessage(), e);
                throw new BaseException(e.getMessage());
            }
    }

    public CreditAndPaymentExcution updatePayment(CreditAndPaymentDto creditAndPaymentDto) {
        int user_id=creditAndPaymentDto.getUser_id();
        try{
            CreditAndPayment info = creditDao.updateCredit(user_id);
            Double credit_total=info.getCreditTotal();
            Double credit_banance=info.getCreditBalance();
            if(credit_total==null){
                credit_total=(double) 0;
            }
            if(credit_banance==null){
                credit_banance=(double) 0;
            }
            Double debt=credit_total-credit_banance;
            info.setDebt(debt);
            return new CreditAndPaymentExcution(CreditEnum.UPDATE_SUCCESS,info);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CreditAndPaymentExcution subCredit(CreditAndPaymentDto creditAndPaymentDto) {
        int user_id=creditAndPaymentDto.getUser_id();
        double credit_total=creditAndPaymentDto.getCredit_total();
        double credit_balance=creditAndPaymentDto.getCredit_balance();
        try {
            int subCredit = creditDao.submitCredit(user_id, credit_total,credit_balance);
            if(subCredit>0){
                return  new CreditAndPaymentExcution(CreditEnum.SUCCESS);
            }else {
                throw new InsertInnerErrorException("插入失败");
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }

    public CreditAndPaymentExcution subPayment(CreditAndPaymentDto creditAndPaymentDto) {
        int  user_id=creditAndPaymentDto.getUser_id();
        String paymnet_days=creditAndPaymentDto.getPayment_days();
        try{
            int subPayment=creditDao.submitPayment(user_id,paymnet_days);
            if(subPayment>0){
                return  new CreditAndPaymentExcution(CreditEnum.SUCCESS);
            }else{
                throw  new InsertInnerErrorException("修改账期失败");
            }
        }catch (InsertInnerErrorException i){
            throw i;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
