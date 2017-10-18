package com.zxjz.service;

import com.zxjz.dto.excution.VIPMerchantAccountExcution;
import com.zxjz.dto.in.VIPMerchantAccountDto;

public interface VIPMerchantAccountService {
    /**
     * 显示VIP商家页面
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution findListVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto);

    /**
     * 添加VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution addVIPMerchantAccount(VIPMerchantAccountDto vipMerchantAccountDto);

    /**
     * 模糊搜索商家名称
     * @return
     */
    public VIPMerchantAccountExcution findMerchantName();

    /**
     * 显示VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution findVIPMerchantObject(VIPMerchantAccountDto vipMerchantAccountDto);

    /**
     * 编辑VIP商家账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution updateVIPMerchantObject(VIPMerchantAccountDto vipMerchantAccountDto);

    /**
     * 显示删除VIP企业账号
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution showDelVIPMerchant(VIPMerchantAccountDto vipMerchantAccountDto);

    /**
     * 删除VIP企业账户
     * @param vipMerchantAccountDto
     * @return
     */
    public VIPMerchantAccountExcution editVIPMerchantPage(VIPMerchantAccountDto vipMerchantAccountDto);
}
