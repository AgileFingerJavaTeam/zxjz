package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.CreditEnum;

public class CreditAndPaymentExcution extends BaseAPIExcution {
    public CreditAndPaymentExcution(CreditEnum creditEnum,Object data) {
        this.code=creditEnum.getCode();
        this.data=data;
    }
    public CreditAndPaymentExcution(CreditEnum creditEnum) {
        this.code=creditEnum.getCode();

    }




}
