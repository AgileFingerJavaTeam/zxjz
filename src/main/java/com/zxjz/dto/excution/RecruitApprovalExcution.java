package com.zxjz.dto.excution;


import com.zxjz.entity.RecruitmentInfoApply;
import com.zxjz.enums.RecruitApprovalEnum;

import java.util.List;

public class RecruitApprovalExcution {
    private List<RecruitmentInfoApply>findApprovallist;
    private RecruitmentInfoApply findApprovalByID;
    private int total;
    private int code;
    private String codeInfo;

    public RecruitApprovalExcution(RecruitApprovalEnum recruitApprovalEnum, List<RecruitmentInfoApply> findApprovallist) {
        this.findApprovallist = findApprovallist;
    }
    public RecruitApprovalExcution(RecruitApprovalEnum recruitApprovalEnum, RecruitmentInfoApply findApprovalByID ) {
        this.findApprovalByID=findApprovalByID;
    }
    public RecruitApprovalExcution(RecruitApprovalEnum recruitApprovalEnum,int total) {
        this.findApprovallist = findApprovallist;
        this.total=total;
    }


    public RecruitApprovalExcution(RecruitApprovalEnum recruitApprovalEnum) {
        this.code =recruitApprovalEnum.getCode() ;
        this.codeInfo = recruitApprovalEnum.getCodeInfo();
    }

    public List<RecruitmentInfoApply> getFindApprovallist() {
        return findApprovallist;
    }

    public void setFindApprovallist(List<RecruitmentInfoApply> findApprovallist) {
        this.findApprovallist = findApprovallist;
    }

    public RecruitmentInfoApply getFindApprovalByID() {
        return findApprovalByID;
    }

    public void setFindApprovalByID(RecruitmentInfoApply findApprovalByID) {
        this.findApprovalByID = findApprovalByID;
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

}
