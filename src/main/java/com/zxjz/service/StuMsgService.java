package com.zxjz.service;


import com.zxjz.dto.excution.StuJobExcution;
import com.zxjz.dto.excution.StuMsgExcution;
import com.zxjz.dto.in.StuJobDto;
import com.zxjz.dto.in.StuMsgDto;

public interface StuMsgService {


        public StuMsgExcution stuMsg(StuMsgDto stuMsgDto);


        public StuMsgExcution stuMsgStat(StuMsgDto stuMsgDto);




}
