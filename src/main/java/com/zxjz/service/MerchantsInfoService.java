package com.zxjz.service;

import com.zxjz.dto.excution.MerchantsAffirmStudentBreakPromiseExcution;
import com.zxjz.dto.excution.MerchantsChangeHeadExcution;
import com.zxjz.dto.excution.MerchantsInfoExcution;
import com.zxjz.dto.excution.MerchantsUpgradeExcution;
import com.zxjz.dto.in.MerchantsAffirmStudentBreakPromiseDto;
import com.zxjz.dto.in.MerchantsChangeHeadDto;
import com.zxjz.dto.in.MerchantsInfoDto;
import com.zxjz.dto.in.MerchantsUpgradeDto;

public interface MerchantsInfoService {
    /**
     * 获取商户信息
     * @param merchantsInfoDto
     * @return
     */
    public MerchantsInfoExcution findEmpolyerInfoById(MerchantsInfoDto merchantsInfoDto);

    /**
     * 变更负责人
     * @param merchantsChangeHeadDto
     * @return
     */
    public MerchantsChangeHeadExcution changeHead(MerchantsChangeHeadDto merchantsChangeHeadDto);

    /**
     * 确认员工爽约
     * @param merchantsAffirmStudentBreakPromiseDto
     * @return
     */
    public MerchantsAffirmStudentBreakPromiseExcution confirmStudentMiss(MerchantsAffirmStudentBreakPromiseDto merchantsAffirmStudentBreakPromiseDto);

    /**
     * 升级账户
     * @param
     * @return
     */
    public MerchantsUpgradeExcution upgradeAccount(MerchantsUpgradeDto merchantsUpgradDto);

    /**
     * 查询申请VIP商户申请信息
     * @param merchantsUpgradeDto
     * @return
     */
    public MerchantsUpgradeExcution showAuditPage(MerchantsUpgradeDto merchantsUpgradeDto);

    /**
     * 查询申请VIP商户列表
     * @param merchantsUpgradeDto
     * @return
     */
//    public MerchantsUpgradeExcution findApplyVipShopList(MerchantsUpgradeDto merchantsUpgradeDto);
}
