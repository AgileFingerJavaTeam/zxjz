package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.MerchantApprovalEnum;
import com.zxjz.enums.RecruitApprovalEnum;

public class MerchantApprovalExcution extends BaseAPIExcution{

    public MerchantApprovalExcution(MerchantApprovalEnum merchantApprovalEnum, Object data) {
        this.code=merchantApprovalEnum.getCode();
        this.data=data;
    }
}
