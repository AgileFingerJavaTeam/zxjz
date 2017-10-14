package com.zxjz.dto.excution;

import com.zxjz.entity.*;
import com.zxjz.enums.CheckBillEnum;

public class CheckBillExcution {
    private RechargeInfo rechargeInfo;
    private MerchantWithdrawInfo merchantWithdrawInfo;
    private MerchantPayforStudent merchantPayforStudent;
    private MerchantPayforTerrace merchantPayforTerrace;
    private TerracePayforStudent terracePayforStudent;
    private int code;
    private String codeInfo;

    public CheckBillExcution(CheckBillEnum checkBillEnum) {
        this.code = checkBillEnum.getCode();
        this.codeInfo = checkBillEnum.getCodeInfo();
    }

    public RechargeInfo getRechargeInfo() {
        return rechargeInfo;
    }

    public void setRechargeInfo(RechargeInfo rechargeInfo) {
        this.rechargeInfo = rechargeInfo;
    }

    public MerchantWithdrawInfo getMerchantWithdrawInfo() {
        return merchantWithdrawInfo;
    }

    public void setMerchantWithdrawInfo(MerchantWithdrawInfo merchantWithdrawInfo) {
        this.merchantWithdrawInfo = merchantWithdrawInfo;
    }

    public MerchantPayforStudent getMerchantPayforStudent() {
        return merchantPayforStudent;
    }

    public void setMerchantPayforStudent(MerchantPayforStudent merchantPayforStudent) {
        this.merchantPayforStudent = merchantPayforStudent;
    }

    public MerchantPayforTerrace getMerchantPayforTerrace() {
        return merchantPayforTerrace;
    }

    public void setMerchantPayforTerrace(MerchantPayforTerrace merchantPayforTerrace) {
        this.merchantPayforTerrace = merchantPayforTerrace;
    }

    public TerracePayforStudent getTerracePayforStudent() {
        return terracePayforStudent;
    }

    public void setTerracePayforStudent(TerracePayforStudent terracePayforStudent) {
        this.terracePayforStudent = terracePayforStudent;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "CheckBillExcution{" +
                "rechargeInfo=" + rechargeInfo +
                ", merchantWithdrawInfo=" + merchantWithdrawInfo +
                ", merchantPayforStudent=" + merchantPayforStudent +
                ", merchantPayforTerrace=" + merchantPayforTerrace +
                ", terracePayforStudent=" + terracePayforStudent +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
