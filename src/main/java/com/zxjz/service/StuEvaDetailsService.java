package com.zxjz.service;

import com.zxjz.dto.excution.StuEvaDetailsExcution;
import com.zxjz.dto.excution.StuPersonalExcution;
import com.zxjz.dto.in.StuEvaDetailsDto;
import com.zxjz.dto.in.StuPersonalDto;

public interface StuEvaDetailsService {

    /**
     * 获取学生总评价
     * @return
     */
    public StuPersonalExcution findStuPersonal(StuPersonalDto stuPersonalDto);

    /**
     * 获取商户对的学生评价列表
     * @return
     */
    public StuEvaDetailsExcution findStuEvaDetails(StuEvaDetailsDto stuEvaDetailsDto);
}
