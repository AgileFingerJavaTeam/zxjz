package com.zxjz.service;

import com.zxjz.dto.excution.*;
import com.zxjz.dto.in.ConfirmRejectionDto;

public interface ConfirmRejectionService {
    /**
     * 商家录用学生接口
     * 是否录取（是/否）
     */
    public ConfirmRejectionExcution updateConReject(ConfirmRejectionDto confirmRejectionDto);
}
