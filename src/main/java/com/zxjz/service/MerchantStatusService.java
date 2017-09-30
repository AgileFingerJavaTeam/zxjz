package com.zxjz.service;

import com.zxjz.dto.excution.MerchantStatusExcution;
import com.zxjz.dto.in.MerchantStatusDto;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface MerchantStatusService {


    public MerchantStatusExcution findMerchantStatus(MerchantStatusDto merchantStatusDto);
}
