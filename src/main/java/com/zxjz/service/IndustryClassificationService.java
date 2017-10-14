package com.zxjz.service;

import com.zxjz.dto.excution.IndustryClassificationExcution;
import com.zxjz.dto.in.IndustryClassificationDto;

public interface IndustryClassificationService {
    /**
     * 获取行业分类列表
     * @return
     */
    public IndustryClassificationExcution findListIndustryClassification();

    /**
     * 添加行业信息
     * @return
     */
    public IndustryClassificationExcution insertIndustry(IndustryClassificationDto industryClassificationDto);

    /**
     * 编辑行业信息
     * @return
     */
    public IndustryClassificationExcution editIndustry(IndustryClassificationDto industryClassificationDto);

    /**
     * 删除行业信息
     * @return
     */
    public IndustryClassificationExcution updateIndustry(IndustryClassificationDto industryClassificationDto);


    public IndustryClassificationExcution findIndustryCategory(IndustryClassificationDto industryClassificationDto);
}
