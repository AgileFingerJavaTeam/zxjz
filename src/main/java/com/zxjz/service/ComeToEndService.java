package com.zxjz.service;

import com.zxjz.dto.excution.ComeToEndExcution;
import com.zxjz.dto.in.ComeToEndDto;

public interface ComeToEndService {
    /**
     * 更新是否结束和结束方
     * @param comeToEndDto
     * @return
     */
    public ComeToEndExcution updateComeToEnd(ComeToEndDto comeToEndDto);
}
