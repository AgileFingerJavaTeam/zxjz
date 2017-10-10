package com.zxjz.dto.excution;

import com.zxjz.entity.CheckBill;
import com.zxjz.entity.MerchantFundsCurrentAccount;
import com.zxjz.enums.RecruitmentEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecruitmentExcution {
    private List<CheckBill> checkBillList;
    private MerchantFundsCurrentAccount merchantFundsCurrentAccount;
    private int code;
    private String codeInfo;

    public RecruitmentExcution(RecruitmentEnum recruitmentEnum,List<CheckBill> checkBillList) {
        this.checkBillList = checkBillList;
        this.code = recruitmentEnum.getCode();
        this.codeInfo = recruitmentEnum.getCodeInfo();
    }

    public RecruitmentExcution(RecruitmentEnum recruitmentEnum, MerchantFundsCurrentAccount merchantFundsCurrentAccount) {
        this.merchantFundsCurrentAccount = merchantFundsCurrentAccount;
        this.code = recruitmentEnum.getCode();
        this.codeInfo = recruitmentEnum.getCodeInfo();
    }

    public RecruitmentExcution(RecruitmentEnum recruitmentEnum) {
        this.code = recruitmentEnum.getCode();
        this.codeInfo = recruitmentEnum.getCodeInfo();
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

    public List<CheckBill> getCheckBillList() {
        return checkBillList;
    }

    public void setCheckBillList(List<CheckBill> checkBillList) {
        this.checkBillList = checkBillList;
    }

    public MerchantFundsCurrentAccount getMerchantFundsCurrentAccount() {
        return merchantFundsCurrentAccount;
    }

    public void setMerchantFundsCurrentAccount(MerchantFundsCurrentAccount merchantFundsCurrentAccount) {
        this.merchantFundsCurrentAccount = merchantFundsCurrentAccount;
    }

    @Override
    public String toString() {
        return "RecruitmentExcution{" +
                "checkBillList=" + checkBillList +
                ", merchantFundsCurrentAccount=" + merchantFundsCurrentAccount +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
