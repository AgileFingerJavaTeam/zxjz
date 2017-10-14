package com.zxjz.service;

import com.zxjz.dto.excution.CreditAndPaymentExcution;
import com.zxjz.dto.in.CreditAndPaymentDto;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public interface CreditAndPaymentService {
    public  CreditAndPaymentExcution findList(CreditAndPaymentDto creditAndPaymentDto);
    public  CreditAndPaymentExcution updateCredit(CreditAndPaymentDto creditAndPaymentDto);
    public  CreditAndPaymentExcution updatePayment(CreditAndPaymentDto creditAndPaymentDto);
    public  CreditAndPaymentExcution subCredit(CreditAndPaymentDto creditAndPaymentDto);
    public  CreditAndPaymentExcution subPayment(CreditAndPaymentDto creditAndPaymentDto);
}
