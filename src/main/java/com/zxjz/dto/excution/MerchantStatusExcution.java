package com.zxjz.dto.excution;

import com.zxjz.entity.MerchantStatusOne;
import com.zxjz.entity.MerchantStatusThree;
import com.zxjz.entity.MerchantStatusTwo;
import com.zxjz.enums.MerchantStatusEnum;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class MerchantStatusExcution {

    private List<MerchantStatusOne> merchantStatusOnes;

    private List<MerchantStatusTwo> merchantStatusTwos;

    private List<MerchantStatusThree> merchantStatusThrees;

    private int code;

    private String codeInfo;

    public MerchantStatusExcution(MerchantStatusEnum merchantStatusEnum,List<MerchantStatusOne> merchantStatusOnes, List<MerchantStatusTwo> merchantStatusTwos, List<MerchantStatusThree> merchantStatusThrees) {
        this.merchantStatusOnes = merchantStatusOnes;
        this.merchantStatusTwos = merchantStatusTwos;
        this.merchantStatusThrees = merchantStatusThrees;
        this.code = merchantStatusEnum.getCode();
        this.codeInfo = merchantStatusEnum.getCodeInfo();
    }



    public MerchantStatusExcution(MerchantStatusEnum merchantStatusEnum) {
        this.code = merchantStatusEnum.getCode();
        this.codeInfo = merchantStatusEnum.getCodeInfo();
    }


    public List<MerchantStatusOne> getMerchantStatusOnes() {
        return merchantStatusOnes;
    }

    public void setMerchantStatusOnes(List<MerchantStatusOne> merchantStatusOnes) {
        this.merchantStatusOnes = merchantStatusOnes;
    }

    public List<MerchantStatusTwo> getMerchantStatusTwos() {
        return merchantStatusTwos;
    }

    public void setMerchantStatusTwos(List<MerchantStatusTwo> merchantStatusTwos) {
        this.merchantStatusTwos = merchantStatusTwos;
    }

    public List<MerchantStatusThree> getMerchantStatusThrees() {
        return merchantStatusThrees;
    }

    public void setMerchantStatusThrees(List<MerchantStatusThree> merchantStatusThrees) {
        this.merchantStatusThrees = merchantStatusThrees;
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
        return "MerchantStatusExcution{" +
                "merchantStatusOnes=" + merchantStatusOnes +
                ", merchantStatusTwos=" + merchantStatusTwos +
                ", merchantStatusThrees=" + merchantStatusThrees +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
