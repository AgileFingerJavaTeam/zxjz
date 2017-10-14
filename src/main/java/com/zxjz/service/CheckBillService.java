package com.zxjz.service;

import com.zxjz.dto.excution.CheckBillExcution;
import com.zxjz.dto.in.CheckBillDto;

public interface CheckBillService {
    /**
     * 查询商户账单信息
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findBills(CheckBillDto checkBillDto);

    /**
     * 查询商户名称
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findMerName(CheckBillDto checkBillDto);

    /**
     * 查询商户充值详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findPayInfoById(CheckBillDto checkBillDto);

    /**
     * 查询商户提现详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findWithdrawInfoById(CheckBillDto checkBillDto);

    /**
     * 查询商户收费单详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findCostInfoById(CheckBillDto checkBillDto);

    /**
     * 查询平台代付工资详情
     * @param checkBillDto
     * @return
     */
    public CheckBillExcution findPaymentInfoById(CheckBillDto checkBillDto);
}
