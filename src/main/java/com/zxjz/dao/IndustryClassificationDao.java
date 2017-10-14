package com.zxjz.dao;

import com.zxjz.entity.IndustryCategory;
import com.zxjz.entity.IndustryClassification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndustryClassificationDao {
    /**
     * 获取行业分类列表
     * @return
     */
    /*@Param("offset") int offset,
     @Param("rows") int rows*/
    public List<IndustryClassification> getListIndustryClassification();

    /**
     * 总数
     * @return
     */
    public int total();

    /**
     * 添加行业ID
     * @return
     */
    public int insertIndustry(@Param("name") String name);

    /**
     * 编辑行业
     * @param value
     * @return
     */
    public int editIndustry(@Param("value") String value);

    /**
     * 删除行业
     * @return
     */
    public int updateIndustry(@Param("value") String value);

    /**
     * 获取单行数据
     * @return
     */
    public IndustryCategory findIndustryCategory(@Param("value") String value);

}
