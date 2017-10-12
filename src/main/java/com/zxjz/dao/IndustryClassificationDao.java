package com.zxjz.dao;

import com.zxjz.entity.IndustryClassification;

import java.util.List;

public interface IndustryClassificationDao {
    /**
     * 获取行业分类列表
     * @return
     */
    /*@Param("offset") int offset,
     @Param("rows") int rows*/
    public List<IndustryClassification> getListIndustryClassification();

}
