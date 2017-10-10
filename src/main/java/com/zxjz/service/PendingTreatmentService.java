package com.zxjz.service;

import com.zxjz.dto.excution.PendingTreatmentExcution;
import com.zxjz.dto.in.PendingTreatmentDto;

public interface PendingTreatmentService {
    /**
     * 获取商户待处理页面兼职列表接口
     * @param pendingTreatmentDto
     * @return
     */
    public PendingTreatmentExcution findPendingTreatment(PendingTreatmentDto pendingTreatmentDto);
}
