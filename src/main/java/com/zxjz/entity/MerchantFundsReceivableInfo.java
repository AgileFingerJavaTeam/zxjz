package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class MerchantFundsReceivableInfo {
    private int userId;//商户ID
    private int serialNumber;//应收款序号
    private String ArrearsTime;//欠款时间
    private String clearNum;//结算序号
    private String deductedS;//应扣款金额
    private String deductedI;//实扣款金额
    private String actualAmount;//应收金额
    private String isBack;//是否收回
    private String backTime;//收回日期
    private int prepaidNumber;//充值序号

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getArrearsTime() {
        return ArrearsTime;
    }

    public void setArrearsTime(String arrearsTime) {
        ArrearsTime = arrearsTime;
    }

    public String getClearNum() {
        return clearNum;
    }

    public void setClearNum(String clearNum) {
        this.clearNum = clearNum;
    }

    public String getDeductedS() {
        return deductedS;
    }

    public void setDeductedS(String deductedS) {
        this.deductedS = deductedS;
    }

    public String getDeductedI() {
        return deductedI;
    }

    public void setDeductedI(String deductedI) {
        this.deductedI = deductedI;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getIsBack() {
        return isBack;
    }

    public void setIsBack(String isBack) {
        this.isBack = isBack;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public int getPrepaidNumber() {
        return prepaidNumber;
    }

    public void setPrepaidNumber(int prepaidNumber) {
        this.prepaidNumber = prepaidNumber;
    }

    @Override
    public String toString() {
        return "MerchantFundsReceivableInfo{" +
                "userId=" + userId +
                ", serialNumber=" + serialNumber +
                ", ArrearsTime='" + ArrearsTime + '\'' +
                ", clearNum='" + clearNum + '\'' +
                ", deductedS='" + deductedS + '\'' +
                ", deductedI='" + deductedI + '\'' +
                ", actualAmount='" + actualAmount + '\'' +
                ", isBack='" + isBack + '\'' +
                ", backTime='" + backTime + '\'' +
                ", prepaidNumber=" + prepaidNumber +
                '}';
    }
}
