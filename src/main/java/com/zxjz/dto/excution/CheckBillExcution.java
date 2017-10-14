package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CheckBillEnum;

public class CheckBillExcution extends BaseAPIExcution{

    public CheckBillExcution( CheckBillEnum checkBillEnum,Object data) {
        this.code = checkBillEnum.getCode();
        this.data = data;
    }
    public CheckBillExcution( CheckBillEnum checkBillEnum) {
        this.code = checkBillEnum.getCode();
    }


}
