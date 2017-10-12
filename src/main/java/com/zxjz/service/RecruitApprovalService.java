package com.zxjz.service;

import com.zxjz.dto.excution.RecruitApprovalExcution;
import com.zxjz.dto.in.RecruitApprovalDto;

public interface RecruitApprovalService {

    /*查看招聘信息列表*/
    public RecruitApprovalExcution findApprovalList(RecruitApprovalDto recruitApprovalDto);
    /*查询招聘信息数量*/
    public RecruitApprovalExcution findTotal(RecruitApprovalDto recruitApprovalDto);
    /*根据招聘id查看详细信息*/
    public RecruitApprovalExcution findApprovalByID(RecruitApprovalDto recruitApprovalDto);
    /*审核信息被拒绝*/
    public RecruitApprovalExcution updateRefuse(RecruitApprovalDto recruitApprovalDto);
    /*审核信息通过*/
    public RecruitApprovalExcution updatePass(RecruitApprovalDto recruitApprovalDto);
    /*审核通过添加到正式表*/
    public RecruitApprovalExcution addMessage(RecruitApprovalDto recruitApprovalDto);
}
