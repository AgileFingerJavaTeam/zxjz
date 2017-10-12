package com.zxjz.service;

import com.zxjz.dto.excution.IndustryClassificationExcution;

public interface IndustryClassificationService {
    /**
     * 获取行业分类列表
     * @return
     */
    public IndustryClassificationExcution findListIndustryClassification();
}
