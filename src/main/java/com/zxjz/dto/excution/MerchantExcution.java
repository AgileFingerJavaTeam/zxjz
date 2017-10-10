package com.zxjz.dto.excution;

import com.zxjz.entity.GetMerchantInfo;
import com.zxjz.entity.GuaranteePositionInfo;
import com.zxjz.entity.InformationCollectionInfo;
import com.zxjz.entity.RegistrationInfo;
import com.zxjz.enums.MerchantEnum;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class MerchantExcution {
    private Map<String,Object> map;
    private GuaranteePositionInfo guaranteePositionInfo;
    private RegistrationInfo registrationInfo;
    private InformationCollectionInfo informationCollectionInfo;
    private GetMerchantInfo getMerchantInfo;
    private int code;
    private String codeInfo;

    public MerchantExcution(MerchantEnum merchantEnum,GetMerchantInfo getMerchantInfo) {
        this.getMerchantInfo = getMerchantInfo;
        this.code = merchantEnum.getCode();
        this.codeInfo = merchantEnum.getCodeInfo();
    }

    public MerchantExcution(MerchantEnum merchantEnum, Map<String, Object> map) {
        this.map = map;
        this.code = merchantEnum.getCode();
        this.codeInfo = merchantEnum.getCodeInfo();
    }

    public MerchantExcution(MerchantEnum merchantEnum, GuaranteePositionInfo guaranteePositionInfo) {
        this.guaranteePositionInfo = guaranteePositionInfo;
        this.code = merchantEnum.getCode();
        this.codeInfo = merchantEnum.getCodeInfo();
    }

    public MerchantExcution(MerchantEnum merchantEnum,RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
        this.code = merchantEnum.getCode();
        this.codeInfo = merchantEnum.getCodeInfo();
    }

    public MerchantExcution(MerchantEnum merchantEnum,InformationCollectionInfo informationCollectionInfo) {
        this.informationCollectionInfo = informationCollectionInfo;
        this.code = merchantEnum.getCode();
        this.codeInfo = merchantEnum.getCodeInfo();
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public GuaranteePositionInfo getGuaranteePositionInfo() {
        return guaranteePositionInfo;
    }

    public void setGuaranteePositionInfo(GuaranteePositionInfo guaranteePositionInfo) {
        this.guaranteePositionInfo = guaranteePositionInfo;
    }

    public RegistrationInfo getRegistrationInfo() {
        return registrationInfo;
    }

    public void setRegistrationInfo(RegistrationInfo registrationInfo) {
        this.registrationInfo = registrationInfo;
    }

    public InformationCollectionInfo getInformationCollectionInfo() {
        return informationCollectionInfo;
    }

    public void setInformationCollectionInfo(InformationCollectionInfo informationCollectionInfo) {
        this.informationCollectionInfo = informationCollectionInfo;
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
        return "MerchantExcution{" +
                "map=" + map +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
