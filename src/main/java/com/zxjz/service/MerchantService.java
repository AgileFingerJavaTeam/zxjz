package com.zxjz.service;

import com.zxjz.dto.excution.MerchantExcution;
import com.zxjz.dto.excution.MerchantInformationExcution;
import com.zxjz.dto.in.MerchantDto;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public interface MerchantService {

     public MerchantExcution merchant(MerchantDto merchantDto);

     public MerchantExcution findOrdinaryMerchant(MerchantDto merchantDto);

     public MerchantInformationExcution findMerchantinfor(MerchantDto merchantDto);
}
