package com.zxjz.dto.excution;

import com.zxjz.entity.AtCollection;
import com.zxjz.enums.SecurityPositionEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class SecurityPositionExcution {
     private AtCollection atCollection;
     private Map map;
     private List<AtCollection> list;
     private int total;
     private int code;
     private String codeInfo;

    public SecurityPositionExcution(AtCollection atCollection, Map map) {
        this.atCollection = atCollection;
        this.map = map;
    }

    public SecurityPositionExcution(SecurityPositionEnum securityPositionEnum, List<AtCollection> list, int total) {
        this.total = total;
        this.list = list;
        this.code = securityPositionEnum.getCode();
        this.codeInfo = securityPositionEnum.getCodeInfo();
    }

    public SecurityPositionExcution(SecurityPositionEnum securityPositionEnum) {
        this.code = securityPositionEnum.getCode();
        this.codeInfo = securityPositionEnum.getCodeInfo();
    }

    public AtCollection getAtCollection() {
        return atCollection;
    }

    public void setAtCollection(AtCollection atCollection) {
        this.atCollection = atCollection;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<AtCollection> getList() {
        return list;
    }

    public void setList(List<AtCollection> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        return "SecurityPositionExcution{" +
                "list=" + list +
                ", total=" + total +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
