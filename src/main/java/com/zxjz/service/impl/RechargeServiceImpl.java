package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.CityDao;
import com.zxjz.dao.RechargeDao;
import com.zxjz.dto.excution.CityExcution;
import com.zxjz.dto.excution.RechargeExcution;
import com.zxjz.dto.in.RechargeDto;
import com.zxjz.entity.*;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.RechargeEnum;
import com.zxjz.exception.UpdateDatabaseException;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.CityService;
import com.zxjz.service.RechargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RechargeDao rechargeDao;
    public RechargeExcution findRechargeList(RechargeDto rechargeDto) {
        String bxw_search_content=rechargeDto.getBxw_search_content();
        String sort=rechargeDto.getSort();
        String order=rechargeDto.getOrder();
        int page=rechargeDto.getPage();
        int rows=rechargeDto.getRows() ;
        int offset = (page - 1) * rows;
        try{
            List<RechargeInfo> rechargelist = rechargeDao.findRechargeList(bxw_search_content,sort,order,page,offset,rows);
            if (rechargelist != null) {
                for (RechargeInfo rec : rechargelist) {
                    String rechargeTime = rec.getRechargeTime();
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if (rechargeTime != null) {
                        Date date = fmt.parse(rechargeTime);
                        String recTime = fmt.format(date);
                        rec.setRechargeTime(recTime);
                    }
                }
            }
            int total = rechargeDao.total(bxw_search_content);
            HashMap map=new HashMap();
            map.put("rows",rechargelist);
            map.put("total",total);
            return  new RechargeExcution(RechargeEnum.SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public RechargeExcution addCharge(RechargeDto rechargeDto) {
        return null;
    }


    public RechargeExcution findRechargePage(RechargeDto rechargeDto) {
        int use_id=Integer.parseInt(rechargeDto.getUser_id());
        int recharge_sequence_number=Integer.parseInt(rechargeDto.getRecharge_sequence_number());
        try{
            RechargeInfo info = rechargeDao.findRechargePage(use_id,recharge_sequence_number);
            return new RechargeExcution(RechargeEnum.SUCCESS,info);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }

    }

    public RechargeExcution checkauth(RechargeDto rechargeDto) {
        String q=rechargeDto.getQ();
        int page=rechargeDto.getPage();
        int rows=rechargeDto.getRows() ;
        int offset = (page - 1) * rows;
        try {
            List<RechargeInfo> infolist = rechargeDao.findMerchantsName(q,offset,rows);
            int total = rechargeDao.count(q);
            HashMap map =new HashMap();
            map.put("rows",infolist);
            map.put("total",total);
            return new RechargeExcution(RechargeEnum.SUCCESS,map);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public RechargeExcution getChargeMethod(RechargeDto rechargeDto) {

        try{
            List<RechargeInfo>  chargemethodlist = rechargeDao.findRechargeMethod();
            return  new RechargeExcution(RechargeEnum.SUCCESS,chargemethodlist);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public RechargeExcution getNum(RechargeDto rechargeDto) {
        int merchants_id=Integer.parseInt(rechargeDto.getMerchants_id());
        try{
            RechargeInfo rechargeid	= rechargeDao.findUserId(merchants_id);
            if(rechargeid!=null){
                int num=rechargeDao.findNum(merchants_id);
                return new RechargeExcution(RechargeEnum.SUCCESS,num);
            }else {
                int up=rechargeDao.updateNum(merchants_id);
                int num=rechargeDao.findNum(merchants_id);
                return new RechargeExcution(RechargeEnum.SUCCESS,num);
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public RechargeExcution saveSubForm(RechargeDto rechargeDto) {
        int user_id=Integer.parseInt(rechargeDto.getUser_id());
        int recharge_sequence_number=Integer.parseInt(rechargeDto.getRecharge_sequence_number());
        String recharge_time=rechargeDto.getRecharge_time();
        int recharge_mode=Integer.parseInt(rechargeDto.getRecharge_mode());
        double amount_of_recharge = Double.parseDouble(rechargeDto.getAmount_of_recharge());
        int payment_platform_flow_number=Integer.parseInt(rechargeDto.getPayment_platform_flow_number());
        String declare=rechargeDto.getDeclare();
        int operating_staff_id=Integer.parseInt(rechargeDto.getOperating_staff_id());
        HashMap map=new HashMap();
        try{
            int recharge =rechargeDao.insertRecharge(user_id,recharge_sequence_number,recharge_time, recharge_mode,amount_of_recharge, payment_platform_flow_number, declare, operating_staff_id);//商户 充值记录插入数据
            if(recharge>0){//插入数据成功
                List<CurrentAccountInfo> accountinfo=rechargeDao.findForList(user_id);//查询流水账user_id是否存在
                int  addaccount=0;
                if(accountinfo==null){
                        addaccount=rechargeDao.insertAccount(user_id,recharge_sequence_number);//商户插入流水账记录，序号 设为1
                    }else {
                        addaccount=rechargeDao.insertAccounts(user_id,recharge_sequence_number,amount_of_recharge);//商户插入流水账记录，序号 设为最大值1
                    }
                    if(addaccount>0){
                        List<MerchantFundsReceivableInfo> receivable=rechargeDao.findRList(user_id);//查询该商户应收款未回收的记录
                        if(receivable!=null){		//有未回收的记录
                            for(int i=0;i<receivable.size();i++){		//遍历未回收的记录
                                MerchantFundsReceivableInfo receive=receivable.get(i);	//逐条取得记录
                                double actual_amount=Double.parseDouble(receive.getActual_amount());//类型转换
                                if(amount_of_recharge>actual_amount){//充值金额大于应收金额
                                    int info=rechargeDao.updateReceivable(user_id,receive.getSerial_number());//是否回收为是
                                   if(info>0){
                                       amount_of_recharge=amount_of_recharge-actual_amount;//剩余充值金额
                                   }else {
                                       throw new UpdateDatabaseException("更改失败");
                                   }
                                }else{
                                    int info=rechargeDao.updateReceivablePart(user_id, receive.getSerial_number(),actual_amount, amount_of_recharge);//是否回收为部分收回
                                    if(info<1){
                                        throw new UpdateDatabaseException("更改失败");
                                    }
                                }
                            }
                        }
                        CreditAndPayment credit=rechargeDao.findCredit(user_id);//查询该商户资金基本信息
                            if(credit!=null){
                                if(credit.getCreditBalance()==credit.getCreditTotal()){//授信余额=授信总额
                                    int upcredit=rechargeDao.updateCredit(user_id,amount_of_recharge);//更新账户余额
                                    if(upcredit>0){
                                        return new RechargeExcution(RechargeEnum.SUCCESS);
                                    }else{
                                        throw new UpdateDatabaseException("更改失败");
                                    }
                                }else{//授信余额不等于授信总额
                                    int debt = (int) (credit.getCreditTotal()-credit.getCreditBalance()); //求欠款金额
                                    if(amount_of_recharge>=debt){//充值金额>欠款金额
                                        amount_of_recharge=amount_of_recharge-debt;//还完欠款的剩余充值金额
                                        int upcredit=rechargeDao.updateCredit(user_id,amount_of_recharge);//计算账户余额
                                        if(upcredit>0){
                                            return new RechargeExcution(RechargeEnum.SUCCESS);
                                        }else{
                                            throw new UpdateDatabaseException("更改失败");
                                        }
                                    }
                                    else{//充值金额<欠款金额
                                        int upcreditbalance=rechargeDao.upcreditbalance(user_id,amount_of_recharge);//授信余额=授信余额+充值金额
                                        if(upcreditbalance>0){
                                            return new RechargeExcution(RechargeEnum.SUCCESS);
                                        }else{
                                            throw new UpdateDatabaseException("更改失败");
                                        }
                                    }
                                }
                            }
                }else {
                        throw new InsertInnerErrorException("流水账记录插入失败");
                    }
            }else{
                throw new InsertInnerErrorException("商户充值记录插入数据失败");
            }
        }catch (InsertInnerErrorException i){
            throw i;
        }catch (UpdateDatabaseException u){
            throw u;
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
        return null;
    }
}
