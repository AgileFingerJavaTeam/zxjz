package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.SettlementDao;
import com.zxjz.dto.excution.SettlementExcution;
import com.zxjz.dto.in.SettlementAddFunctionDto;
import com.zxjz.dto.in.SettlementDto;
import com.zxjz.entity.MerchantsMoneyBasic;
import com.zxjz.entity.Settlement;
import com.zxjz.enums.SettlementEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.UpdateInnerErrorException;
import com.zxjz.service.SettlementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public SettlementExcution saveFunction(SettlementAddFunctionDto settlementAddFunctionDto) {
                   String settlement_time = settlementAddFunctionDto.getSettlement_time();
                   int user_id = settlementAddFunctionDto.getUser_id();
                   int withdrawal_serial_number = settlementAddFunctionDto.getWithdrawal_serial_number();
                   double settlement_amount = settlementAddFunctionDto.getSettlement_amount();
                   String instructions = settlementAddFunctionDto.getInstructions();
                   int classification_of_settlement_expenses = settlementAddFunctionDto.getClassification_of_settlement_expenses();
                   int employees_id = settlementAddFunctionDto.getEmployees_id();
          try {   //事务1
                        int settlement = settlementDao.insertPlatformBalanceSheet(user_id, withdrawal_serial_number, classification_of_settlement_expenses, settlement_amount, instructions, employees_id);
                    if(settlement <= 0){
                        throw new InsertInnerErrorException("添加失败");
                    }
                  //事务2
                        Settlement infolist = settlementDao.findIsEverUserId(user_id);
                    if(infolist == null){        //如果不存在
                        int current =  settlementDao.insertRunningAccount(user_id,classification_of_settlement_expenses,settlement_amount,withdrawal_serial_number);
                            if(current <= 0 ){
                                throw new InsertInnerErrorException("添加失败");
                            }
                    }else{
                        Settlement sinfo = settlementDao.findIsEverUserId2(user_id);
                        Settlement dinfo = settlementDao.findIsEverUserId3(user_id);
                        int current = dinfo.getCurrent();
                        int currents = settlementDao.insertRunningAccount2(user_id,current,classification_of_settlement_expenses,settlement_amount,withdrawal_serial_number);  //插入流水账表
                            if(current <= 0 ){
                                throw new InsertInnerErrorException("添加失败");
                            }
                    }
                    //事务3
                    MerchantsMoneyBasic info = settlementDao.findMoneyTable(user_id);
                          String a = info.getAccountBalance(); //取账户余额
                          double balance=Double.parseDouble(a);  //账户余额转double
                           // 取收费总额
                          double setll = settlement_amount;  //收费总额转double
                          double credit = info.getCreditBalance();//取授信余额
                          double cretotal= info.getCreditTotal(); //取授信总额
                      if(balance >= setll) {    //如果账户余额 >= 收费金额
                          double balanced = balance - setll; //账户余额 - 收费金额 = 当前账户余额
                          int money = settlementDao.updateMoney(user_id, balanced); //把账户余额 改成 当前账户余额数
                          if (money > 0) {
                              return new SettlementExcution(SettlementEnum.UPDATE_PSW_SUCCESS);
                          } else {
                              throw new UpdateInnerErrorException("更改失败");
                          }
                      }
                        //事务控制4   插入欠款记录表(在事务3 资金不满足的情况下执行)
                          double crbatotal = balance+credit;   //crbatotal = 账户余额 + 授信余额
                      if(crbatotal >= setll) {   //如果crbatotal >= 收费金额
                          double creditd = credit - (setll - balance);  //creditd = 当前授信余额
                          int money = settlementDao.updateMoney2(user_id, creditd); //把账户余额改为0,授信余额为creditd
                          if (money > 0) {
                              Settlement vable = settlementDao.findSerial(user_id); //查询欠款表最大应收款序号
                              double Arrears = cretotal - creditd;  //欠款金额=Arrears        Arrears=授信总额-授信余额
                              if (vable == null) {
                                  if (balance >= setll) {  //如果余额 >= 收费金额
                                      int debt = settlementDao.saveDebt(user_id,settlement_time,withdrawal_serial_number,setll,Arrears);
                                      if(debt <= 0){
                                          throw new InsertInnerErrorException("插入欠款记录失败");
                                      }else{
                                          return new SettlementExcution(SettlementEnum.ADD_JOB_SUCCESS);
                                      }
                                  }else{
                                      int debt = settlementDao.saveDebt2(user_id,settlement_time,withdrawal_serial_number,setll,balance,Arrears); //插入欠款记录表 最大应收款为1  实际应收款为账户余额
                                      if(debt <= 0){
                                          throw new InsertInnerErrorException("插入欠款记录失败");
                                      }else{
                                          return new SettlementExcution(SettlementEnum.ADD_JOB_SUCCESS);
                                      }
                                  }
                              }
                              int ser = vable.getSerial();    //取出最大应收款序号
                              if(balance >= setll){  //如果余额 >= 收费金额
                                  int debt = settlementDao.saveDebt3(user_id,ser,settlement_time,withdrawal_serial_number,setll,Arrears);  //插入欠款记录表 最大应收款+1 实际应收款为收费金额
                                  if(debt <= 0){
                                      throw new InsertInnerErrorException("插入欠款记录失败");
                                  }
                              }else{
                                  int debt = settlementDao.saveDebt4(user_id,ser,settlement_time,withdrawal_serial_number,setll,balance,Arrears);   //插入欠款记录表 最大应收款+1 实际应收款为账户余额
                                  if(debt <= 0){
                                      throw new InsertInnerErrorException("插入欠款记录失败");
                                  }
                              }
                          }
                      }else if(crbatotal < setll){
                            throw new InsertInnerErrorException("插入欠款记录失败");
                                  }
                            return new SettlementExcution(SettlementEnum.ADD_JOB_SUCCESS);
                  }catch (InsertInnerErrorException e1) {
                         throw e1;
                  }catch (UpdateInnerErrorException e2) {
                         throw e2;
                  }catch (Exception e) {
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
