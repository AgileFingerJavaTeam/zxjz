package com.zxjz.dto.excution;

import com.zxjz.entity.BillList;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class BillListExcution {
    private List<BillList> billLists;
    private int code;
    private String codeInfo;

    public BillListExcution(List<BillList> billLists, StuPersonalEnum stuPersonalEnum) {
        this.billLists = billLists;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public BillListExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public List<BillList> getBillLists() {
        return billLists;
    }

    public void setBillLists(List<BillList> billLists) {
        this.billLists = billLists;
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
        return "BillListExcution{" +
                "billLists=" + billLists +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
