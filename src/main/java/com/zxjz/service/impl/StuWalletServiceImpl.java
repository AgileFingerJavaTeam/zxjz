package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StuWalletDao;
import com.zxjz.dto.excution.StuWalletExcution;
import com.zxjz.dto.excution.StuWalletIncomeExcution;
import com.zxjz.dto.excution.StuWalletWithdrawExcution;
import com.zxjz.dto.in.StuWalletDto;
import com.zxjz.dto.in.StuWalletIncomeDto;
import com.zxjz.dto.in.StuWalletWithdrawDto;
import com.zxjz.entity.StuWallletBase;
import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.WalletIncomeEnum;
import com.zxjz.enums.WalletWithdrawEnum;
import com.zxjz.exception.db.InsertInnerErrorException;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.StuWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuWalletServiceImpl implements StuWalletService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StuWalletDao stuWalletDao;

    public StuWalletExcution walletbalance(StuWalletDto stuWalletDto) {
       int userid= stuWalletDto.getUserid();
       try{
           StuWallletBase stuWalletBase=stuWalletDao.findBalance(userid);
            if (stuWalletBase==null){
                throw  new QueryInnerErrorException("用户ID不存在");
            }
            return  new StuWalletExcution(StuWalletEnum.SUCCESS,stuWalletBase);
       }catch (QueryInnerErrorException q){
           throw q;
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           throw new BaseException(e.getMessage());
       }
    }

    public StuWalletIncomeExcution income(StuWalletIncomeDto stuWalletIncomeDto) {
        int userid=stuWalletIncomeDto.getUserid();
        String  start=stuWalletIncomeDto.getStart();
        String end=stuWalletIncomeDto.getEnd();
        try{
          List<WalletIncomeInfo> walletIncomeInfo= stuWalletDao.findListIncome(userid,start,end);
          ArrayList finalInfoList = new ArrayList();
            for(int i=0;i<walletIncomeInfo.size();i++){
                WalletIncomeInfo walletincomeInfo=walletIncomeInfo.get(i);
                int accountnember=walletincomeInfo.getRunningAccountNumber();
                WalletIncomeInfo tempInfo = null;
                if(walletincomeInfo.getClassification().equals("2")){
                    tempInfo =stuWalletDao.findPriceTypeIncome(userid,accountnember);
                }else{
                    tempInfo = stuWalletDao.findOtherTypeIncome(userid,accountnember);
                }
                finalInfoList.add(tempInfo);
            }
            if(finalInfoList!=null){
                return  new StuWalletIncomeExcution(WalletIncomeEnum.SUCCESS,finalInfoList);
            }else {
                throw new QueryInnerErrorException("ID不存在");
            }
        }catch (QueryInnerErrorException q){
            throw q;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
    @Transactional
    public StuWalletWithdrawExcution withdraw(StuWalletWithdrawDto stuWalletWithdrawDto) {
        int userid=stuWalletWithdrawDto.getUserid();
        double money=stuWalletWithdrawDto.getMoney();
        try{
            List<WalletIncomeInfo> findRunningId=stuWalletDao.findRunningId(userid);
            if(findRunningId!=null&&findRunningId.size()>0){
                int addApplyWithdraw=stuWalletDao.addApplyWithdraw(userid,money);
                if(addApplyWithdraw>0){
                    List<WalletIncomeInfo> findid=stuWalletDao.findId(userid);
                    if(findid!=null&&findid.size()>0){
                        int apply=stuWalletDao.addWithdraw(userid,money);
                        if(apply>0){
                            int flag=stuWalletDao.updateWalletBalance(userid,money);
                            if(flag>0){
                                return new StuWalletWithdrawExcution(WalletWithdrawEnum.ADDSUCCESS);
                            }else {
                                throw new InsertInnerErrorException("修改账户余额失败");
                            }
                        }else{
                            throw new InsertInnerErrorException("插入提现流水失败");
                        }
                    }else{
                        int apply=stuWalletDao.addWithdrawFirst(userid,money);
                        if(apply>0){
                            int flag=stuWalletDao.updateWalletBalance(userid,money);
                            if(flag>0){
                                return new StuWalletWithdrawExcution(WalletWithdrawEnum.ADDSUCCESS);
                            }else {
                                throw new InsertInnerErrorException("修改账户余额失败");
                            }
                        }else{
                            throw new InsertInnerErrorException("插入提现流水失败");
                        }
                    }
                }else {
                    throw new InsertInnerErrorException("插入学生钱包流水账失败");
                }
            }else{
                int addApplyWithdrawFirst =stuWalletDao.addApplyWithdrawFirst(userid,money);
                if (addApplyWithdrawFirst >0) {
                    List<WalletIncomeInfo>  findid=stuWalletDao.findId(userid);
                    if(findid!=null&&findid.size()>0){
                        int apply=stuWalletDao.addWithdraw(userid,money);
                        if(apply>0){
                            int flag=stuWalletDao.updateWalletBalance(userid,money);
                            if(flag>0){
                                return new StuWalletWithdrawExcution(WalletWithdrawEnum.ADDSUCCESS);
                            }else {
                                throw new InsertInnerErrorException("修改账户余额失败");
                            }
                        }else{
                            throw new InsertInnerErrorException("插入提现流水失败");
                        }
                    }else{
                        int apply=stuWalletDao.addWithdrawFirst(userid,money);
                        if(apply>0){
                            int flag=stuWalletDao.updateWalletBalance(userid,money);
                            if(flag>0){
                                return new StuWalletWithdrawExcution(WalletWithdrawEnum.ADDSUCCESS);
                            }else {
                                throw new InsertInnerErrorException("修改账户余额失败");
                            }
                        }else{
                            throw new InsertInnerErrorException("插入提现流水失败");
                        }
                    }
                } else {
                    throw new InsertInnerErrorException("插入学生钱包流水账失败");
                }
            }
        }catch (InsertInnerErrorException i){
            throw i;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
