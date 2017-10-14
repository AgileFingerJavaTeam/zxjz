package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.City;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.RechargeEnum;

import java.util.List;

public class RechargeExcution extends BaseAPIExcution{
    public RechargeExcution(RechargeEnum rechargeEnum) {
        this.code=rechargeEnum.getCode();
    }

    public RechargeExcution(RechargeEnum rechargeEnum,Object data) {
        this.code=rechargeEnum.getCode();
        this.data=data;
    }
}
