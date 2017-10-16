package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.base.BaseException;
import com.zxjz.entity.RecruitmentInfoApply;
import com.zxjz.enums.RecruitApprovalEnum;

import java.util.List;

public class RecruitApprovalExcution extends BaseAPIExcution{

    public RecruitApprovalExcution(RecruitApprovalEnum recruitApprovalEnum,Object data) {
        this.code=recruitApprovalEnum.getCode();
        this.data=data;
    }
}
