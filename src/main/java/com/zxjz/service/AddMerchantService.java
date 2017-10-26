package com.zxjz.service;

import com.zxjz.dto.excution.AddMerchantExcution;
import com.zxjz.dto.in.AddMerchantDto;

import java.util.List;

public interface AddMerchantService {
    /**
     * 查询商户列表
     * @return
     */
    public AddMerchantExcution findMerchantList(AddMerchantDto addMerchantDto);

    /**
     * 新增商户
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution insertMerchant(AddMerchantDto addMerchantDto);
    /**
     * 查询当前选择的商户信息
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution findMerchantInfo(AddMerchantDto addMerchantDto);

    /**
     * 编辑商户
     * @param addMerchantDto
     * @return
     */
    public AddMerchantExcution editMerchant(AddMerchantDto addMerchantDto);

}
