package com.zxjz.service;

import com.zxjz.dto.excution.MerchantApprovalExcution;
import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.in.MerchantApprovalDto;
import com.zxjz.dto.in.RecruitApprovalDto;

public interface MerchantApprovalService {

    /*查看招聘信息列表*/
    public MerchantApprovalExcution findApprovalList(MerchantApprovalDto merchantApprovalDto);
    /*根据招聘id查看详细信息*/
    public MerchantApprovalExcution findApprovalByID(MerchantApprovalDto merchantApprovalDto);
    /*审核商家信息*/
    public MerchantApprovalExcution result(MerchantApprovalDto merchantApprovalDto);


}
