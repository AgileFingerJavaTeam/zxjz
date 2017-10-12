package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class Settlement {
    //码表
    private int clearingFeeMode;
    private String clearingFeeName;
    //服务费表
    private int withlist; //流水号最大值
    private int userId;  //用户ID
    private int withdrawalSerialNumber; //提现序号
    private int classificationOfSettlementExpenses; //结算费用分类
    private String settlementTime;   //结算时间
    private double settlementAmount; //结算金额
    private String instructions;   //说明
    private int employeesId; //员工ID

    //商户表
    private String merchantsName; //商户名称

    //流水账表
    private int currentAccountNumber; //流水账序号
    private int current;//水流帐最大值+1

    //商户资金表
    private String accountBalance; //商户余额
    private double creditBalance; //授信余额
    private double 	creditTotal; //授信总额
    private String referenceBillClassification; //票据分类

    //欠款记录表
    private int serialNumber; //应收款序号
    private int serial; //最大应收款序号
    private String ArrearsTime; //拖欠时间
    private String clearNum; //结算序号
    private String deductedS; //应扣款金额
    private String deductedI; //实扣款金额
    private String actualAmount; //应收金额
    private String isBack; //是否收回
    private String backTime; //收回日期
    private int prepaidNumber;//充值序号

    //员工表
    private String employeesName; //员工姓名

    public int getClearingFeeMode() {
        return clearingFeeMode;
    }

    public void setClearingFeeMode(int clearingFeeMode) {
        this.clearingFeeMode = clearingFeeMode;
    }

    public String getClearingFeeName() {
        return clearingFeeName;
    }

    public void setClearingFeeName(String clearingFeeName) {
        this.clearingFeeName = clearingFeeName;
    }

    public int getWithlist() {
        return withlist;
    }

    public void setWithlist(int withlist) {
        this.withlist = withlist;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWithdrawalSerialNumber() {
        return withdrawalSerialNumber;
    }

    public void setWithdrawalSerialNumber(int withdrawalSerialNumber) {
        this.withdrawalSerialNumber = withdrawalSerialNumber;
    }

    public int getClassificationOfSettlementExpenses() {
        return classificationOfSettlementExpenses;
    }

    public void setClassificationOfSettlementExpenses(int classificationOfSettlementExpenses) {
        this.classificationOfSettlementExpenses = classificationOfSettlementExpenses;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(double creditTotal) {
        this.creditTotal = creditTotal;
    }

    public String getReferenceBillClassification() {
        return referenceBillClassification;
    }

    public void setReferenceBillClassification(String referenceBillClassification) {
        this.referenceBillClassification = referenceBillClassification;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
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

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "clearingFeeMode=" + clearingFeeMode +
                ", clearingFeeName='" + clearingFeeName + '\'' +
                ", withlist=" + withlist +
                ", userId=" + userId +
                ", withdrawalSerialNumber=" + withdrawalSerialNumber +
                ", classificationOfSettlementExpenses=" + classificationOfSettlementExpenses +
                ", settlementTime='" + settlementTime + '\'' +
                ", settlementAmount=" + settlementAmount +
                ", instructions='" + instructions + '\'' +
                ", employeesId=" + employeesId +
                ", merchantsName='" + merchantsName + '\'' +
                ", currentAccountNumber=" + currentAccountNumber +
                ", current=" + current +
                ", accountBalance='" + accountBalance + '\'' +
                ", creditBalance=" + creditBalance +
                ", creditTotal=" + creditTotal +
                ", referenceBillClassification='" + referenceBillClassification + '\'' +
                ", serialNumber=" + serialNumber +
                ", serial=" + serial +
                ", ArrearsTime='" + ArrearsTime + '\'' +
                ", clearNum='" + clearNum + '\'' +
                ", deductedS='" + deductedS + '\'' +
                ", deductedI='" + deductedI + '\'' +
                ", actualAmount='" + actualAmount + '\'' +
                ", isBack='" + isBack + '\'' +
                ", backTime='" + backTime + '\'' +
                ", prepaidNumber=" + prepaidNumber +
                ", employeesName='" + employeesName + '\'' +
                '}';
    }
}
