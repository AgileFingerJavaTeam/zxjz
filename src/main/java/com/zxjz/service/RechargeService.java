package com.zxjz.service;


import com.zxjz.dto.excution.RechargeExcution;
import com.zxjz.dto.in.RechargeDto;

public interface RechargeService {
    public RechargeExcution findRechargeList(RechargeDto rechargeDto);

    public RechargeExcution addCharge(RechargeDto rechargeDto);

    public RechargeExcution findRechargePage(RechargeDto rechargeDto);

    public RechargeExcution checkauth(RechargeDto rechargeDto);

    public RechargeExcution getChargeMethod(RechargeDto rechargeDto);

    public RechargeExcution getNum(RechargeDto rechargeDto);

    public RechargeExcution saveSubForm(RechargeDto rechargeDto);
}

