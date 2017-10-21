package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/20 0020.
 */
public class MarchantArrear {

       private int userId;
       private int serialNumber;
       private String ArrearsTime;
       private String clearNum;
       private String deductedS;
       private String deductedI;
       private String actualAmount;
       private String isBack;
       private String backTime;
       private int prepaidNumber;

       private String accountBalance;
       private String alipayId;
       private String wechatId;
       private double creditTotal;
       private double creditBalance;
       private String PaymentDays;
       private String payPsw;
       private int isNeedPsw;
       private int notNeedPswPeriod;

       private String merchantsName;
       private double sumActual;
       private double querySumActual;
       private double sumCreditTotal;

    public double getSumCreditTotal() {
        return sumCreditTotal;
    }

    public void setSumCreditTotal(double sumCreditTotal) {
        this.sumCreditTotal = sumCreditTotal;
    }

    public double getQuerySumActual() {
        return querySumActual;
    }

    public void setQuerySumActual(double querySumActual) {
        this.querySumActual = querySumActual;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public double getSumActual() {
        return sumActual;
    }

    public void setSumActual(double sumActual) {
        this.sumActual = sumActual;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(double creditTotal) {
        this.creditTotal = creditTotal;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getPaymentDays() {
        return PaymentDays;
    }

    public void setPaymentDays(String paymentDays) {
        PaymentDays = paymentDays;
    }

    public String getPayPsw() {
        return payPsw;
    }

    public void setPayPsw(String payPsw) {
        this.payPsw = payPsw;
    }

    public int getIsNeedPsw() {
        return isNeedPsw;
    }

    public void setIsNeedPsw(int isNeedPsw) {
        this.isNeedPsw = isNeedPsw;
    }

    public int getNotNeedPswPeriod() {
        return notNeedPswPeriod;
    }

    public void setNotNeedPswPeriod(int notNeedPswPeriod) {
        this.notNeedPswPeriod = notNeedPswPeriod;
    }

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
        return "MarchantArrear{" +
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
                ", accountBalance='" + accountBalance + '\'' +
                ", alipayId='" + alipayId + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", creditTotal=" + creditTotal +
                ", creditBalance=" + creditBalance +
                ", PaymentDays='" + PaymentDays + '\'' +
                ", payPsw='" + payPsw + '\'' +
                ", isNeedPsw=" + isNeedPsw +
                ", notNeedPswPeriod=" + notNeedPswPeriod +
                ", merchantsName='" + merchantsName + '\'' +
                ", sumActual=" + sumActual +
                ", querySumActual=" + querySumActual +
                ", sumCreditTotal=" + sumCreditTotal +
                '}';
    }
}
