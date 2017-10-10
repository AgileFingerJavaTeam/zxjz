package com.zxjz.service;

import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.dto.in.PaypsdDto;
import com.zxjz.dto.in.RecruitmentDto;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public interface RecruitmentService {

    public RecruitmentExcution postjob(RecruitmentDto recruitmentDto);

    public RecruitmentExcution postjobcopy(RecruitmentDto recruitmentDto);

    public RecruitmentExcution postfailure(RecruitmentDto RecruitmentDto);

    public RecruitmentExcution editpostjobcopy(RecruitmentDto recruitmentDto);

    public RecruitmentExcution editJob(RecruitmentDto recruitmentDto);

    public RecruitmentExcution setpaypsd(PaypsdDto paypsdDto);

    public RecruitmentExcution tradingRecord(PaypsdDto paypsdDto);

    public RecruitmentExcution checkBill(CheckBillDto checkBillDto);
}
