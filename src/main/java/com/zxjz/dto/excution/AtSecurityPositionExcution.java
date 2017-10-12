package com.zxjz.dto.excution;

import com.zxjz.enums.SecurityPositionEnum;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class AtSecurityPositionExcution {
      private Map map;
      private int code;
      private String codeInfo;


    public AtSecurityPositionExcution(SecurityPositionEnum securityPositionEnum,Map map) {
        this.map = map;
        this.code = securityPositionEnum.getCode();
        this.codeInfo = securityPositionEnum.getCodeInfo();
    }

    public AtSecurityPositionExcution(SecurityPositionEnum securityPositionEnum) {
        this.code = securityPositionEnum.getCode();
        this.codeInfo = securityPositionEnum.getCodeInfo();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
        return "AtSecurityPositionExcution{" +
                "map=" + map +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
