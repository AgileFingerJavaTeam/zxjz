package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.StuJobDao;
import com.zxjz.dao.StuWalletDao;
import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.excution.StuWalletExcution;
import com.zxjz.dto.excution.StuWalletIncomeExcution;
import com.zxjz.dto.excution.StuWalletWithdrawExcution;
import com.zxjz.dto.in.StuJobDto;
import com.zxjz.dto.in.StuWalletDto;
import com.zxjz.dto.in.StuWalletIncomeDto;
import com.zxjz.dto.in.StuWalletWithdrawDto;
import com.zxjz.entity.StuJob;
import com.zxjz.entity.StuWallletBase;
import com.zxjz.entity.WalletIncomeInfo;
import com.zxjz.enums.StuJobEnum;
import com.zxjz.enums.StuWalletEnum;
import com.zxjz.enums.WalletIncomeEnum;
import com.zxjz.enums.WalletWithdrawEnum;
import com.zxjz.exception.QueryInnerErrorException;
import com.zxjz.service.StuJobService;
import com.zxjz.service.StuWalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StuJobServiceImpl implements StuJobService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StuJobDao stuJobDao;


    public StuJobExcution stuJob(StuJobDto stuJobDto) {
        int userid=stuJobDto.getUserid();
        try{
            StuJob stuJob=stuJobDao.findJob(userid);
            if(stuJob!=null){
                return  new StuJobExcution(StuJobEnum.SUCCESS,stuJob);
            }else {
                throw new QueryInnerErrorException("获取兼职数据失败");
            }
        } catch (QueryInnerErrorException  q){
            throw q;
        } catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    public StuJobExcution stuJobList(StuJobDto stuJobDto) {
        int userid=stuJobDto.getUserid();
        int type=stuJobDto.getType();
        try{
            List<StuJob> stujoblist=stuJobDao.findjoblist(userid,type);
            if(stujoblist!=null){
                return  new StuJobExcution(StuJobEnum.SUCCESS,stujoblist);
            }else {
                throw new QueryInnerErrorException("获取兼职列表失败");
            }
        }catch (QueryInnerErrorException  q){
            throw q;
        }catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
