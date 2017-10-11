package com.zxjz.service;

import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.SecurityPositionDto;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public interface SecurityPositionService {
    /**
     * 显示数据
     * @param securityPositionDto
     * @return
     */
    public SecurityPositionExcution getSecurityPositionList(SecurityPositionDto securityPositionDto);

    public SecurityPositionExcution getSecurityPosition(SecurityPositionDto securityPositionDto);
}
