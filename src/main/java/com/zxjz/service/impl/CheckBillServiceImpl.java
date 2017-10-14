package com.zxjz.service.impl;

import com.zxjz.base.BaseException;
import com.zxjz.dao.CheckBillDao;
import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.entity.*;
import com.zxjz.enums.CheckBillEnum;
import com.zxjz.exception.db.QueryInnerErrorException;
import com.zxjz.service.CheckBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class CheckBillServiceImpl implements CheckBillService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CheckBillDao checkBillDao;

    /**
     * 查询商户账单信息
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findBills(CheckBillDto checkBillDto) {
        int user_id = checkBillDto.getUser_id();
        String q = checkBillDto.getQ();
        try {
            List<MerchantsBillsInfo> bills = checkBillDao.findBillsInfo(user_id);
            if (bills == null){
                throw new QueryInnerErrorException("查询商户账单失败");
            }
            int billsCount = checkBillDao.findMerBillsCount(q);
            if (billsCount == 0){
                throw new QueryInnerErrorException("查询商户账单数量失败");
            }
            HashMap map = new HashMap();
            map.put("bills",bills);
            map.put("billsCount",billsCount);
            return new CheckBillExcution(CheckBillEnum.FIND_BILL_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询商户名称
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findMerName(CheckBillDto checkBillDto) {
        int page = checkBillDto.getPage();
        int rows = checkBillDto.getRows();
        int offset = (page-1)*rows;
        String q = checkBillDto.getQ();
        try {
            List<MerchantsBillsInfo> merchantsNameList = checkBillDao.findMerchantName(q,offset,rows);
            if (merchantsNameList == null){
                throw new QueryInnerErrorException("查询商户名称失败");
            }
            int mechantsNameCount = checkBillDao.findMerCount(q);
            if (mechantsNameCount == 0){
                throw new QueryInnerErrorException("查询查找时商户条数失败");
            }
            HashMap map = new HashMap();
            map.put("merchantsList",merchantsNameList);
            map.put("merchantsCount",mechantsNameCount);
            return new CheckBillExcution(CheckBillEnum.FIND_MERCHANTS_NAME_SUCCESS,map);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询商户充值详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findPayInfoById(CheckBillDto checkBillDto) {
        int user_id = checkBillDto.getUser_id();
        int references_the_internal_serial_number1 = checkBillDto.getReferences_the_internal_serial_number1();
        try {
            RechargeInfo rechargeInfo = checkBillDao.findPayInfoById(user_id,references_the_internal_serial_number1);
            if (rechargeInfo == null){
                throw new QueryInnerErrorException("查询商户充值信息失败");
            }
            return new CheckBillExcution(CheckBillEnum.FIND_MERCHANTS_PAY_SUCCESS,rechargeInfo);
        } catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询商户提现详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findWithdrawInfoById(CheckBillDto checkBillDto) {
        int user_id = checkBillDto.getUser_id();
        int references_the_internal_serial_number1 = checkBillDto.getReferences_the_internal_serial_number1();
        try {
            MerchantWithdrawInfo merchantWithdrawInfo = checkBillDao.findWithdrawInfoById(user_id,references_the_internal_serial_number1);
            if (merchantWithdrawInfo == null){
                throw new QueryInnerErrorException("查询商户提现详情失败");
            }
            return new CheckBillExcution(CheckBillEnum.FIND_MERCHANTS_WITHDRAW_SUCCESS,merchantWithdrawInfo);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 查询收费单
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findCostInfoById(CheckBillDto checkBillDto) {
        int user_id = checkBillDto.getUser_id();
        int references_the_internal_serial_number1 = checkBillDto.getReferences_the_internal_serial_number1();
        try {
            MerchantPayforTerrace merchantPayforTerrace = checkBillDao.findCostInfoById(user_id,references_the_internal_serial_number1);
            if (merchantPayforTerrace == null){
                throw new QueryInnerErrorException("查询收费单详情失败");
            }
            return new CheckBillExcution(CheckBillEnum.FIND_MERCHANTS_COST_SUCCESS,merchantPayforTerrace);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    public CheckBillExcution findPaymentInfoById(CheckBillDto checkBillDto) {
        int user_id = checkBillDto.getUser_id();
        int references_the_internal_serial_number1 = checkBillDto.getReferences_the_internal_serial_number1();
        try {
            TerracePayforStudent terracePayforStudent = checkBillDao.findPaymentInfoById(user_id,references_the_internal_serial_number1);
            if (terracePayforStudent == null){
                throw new QueryInnerErrorException("查询平台代付工资详情失败");
            }
            return  new CheckBillExcution(CheckBillEnum.FIND_PAYMENT_INFO_SUCCESS,terracePayforStudent);
        }catch (QueryInnerErrorException e1){
            throw e1;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }
}
