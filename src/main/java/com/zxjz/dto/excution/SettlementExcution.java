package com.zxjz.dto.excution;

import com.zxjz.entity.Settlement;
import com.zxjz.enums.SettlementEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class SettlementExcution {
      private Map map;
      private String withlist;
      private List<Settlement> infoList;
      private Settlement settlement;
      private int total;
      private int code;
      private String codeInfo;

    public SettlementExcution(SettlementEnum settlementEnum,Map map) {
        this.map = map;
        this.code = settlementEnum.getCode();
        this.codeInfo = settlementEnum.getCodeInfo();
    }

    public SettlementExcution(SettlementEnum settlementEnum, String withlist) {
        this.withlist = withlist;
        this.code = settlementEnum.getCode();
        this.codeInfo = settlementEnum.getCodeInfo();
    }

    public SettlementExcution(SettlementEnum settlementEnum, Settlement settlement) {
        this.settlement = settlement;
        this.code = settlementEnum.getCode();
        this.codeInfo = settlementEnum.getCodeInfo();
    }

    public SettlementExcution(SettlementEnum settlementEnum, List<Settlement> infoList, int total) {
        this.total = total;
        this.infoList = infoList;
        this.code = settlementEnum.getCode();
        this.codeInfo = settlementEnum.getCodeInfo();
    }

    public SettlementExcution(SettlementEnum settlementEnum) {
        this.code = settlementEnum.getCode();
        this.codeInfo = settlementEnum.getCodeInfo();
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Settlement> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Settlement> infoList) {
        this.infoList = infoList;
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
        return "SettlementExcution{" +
                "infoList=" + infoList +
                ", settlement=" + settlement +
                ", total=" + total +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
