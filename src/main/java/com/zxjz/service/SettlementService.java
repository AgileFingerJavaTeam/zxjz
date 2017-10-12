package com.zxjz.service;

import com.zxjz.dto.excution.SettlementExcution;
import com.zxjz.dto.in.SettlementAddFunctionDto;
import com.zxjz.dto.in.SettlementDto;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public interface SettlementService {
    /**
     * 显示数据
     * @param settlementDto
     * @return
     */
    public SettlementExcution findListSettlement(SettlementDto settlementDto);

    /**
     * 模糊查询
     * @param settlementDto
     * @return
     */
    public SettlementExcution findSearch(SettlementDto settlementDto);

    /**
     * 查看
     * @param settlementDto
     * @return
     */
    public SettlementExcution getSettlementData(SettlementDto settlementDto);

    /**
     * 添加窗口查流水号+1
     * @param settlementDto
     * @return
     */
    public SettlementExcution findMaxNumber(SettlementDto settlementDto);

    /**
     * 添加方法   事务控制
     * @param settlementAddFunctionDto
     * @return
     */
    public SettlementExcution saveFunction(SettlementAddFunctionDto settlementAddFunctionDto);

    /**
     * 查询商户名称
     * @param settlementDto
     * @return
     */
    public SettlementExcution findMerchantsName(SettlementDto settlementDto);
}
