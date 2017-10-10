package com.zxjz.dao;

import com.zxjz.entity.PendingTreatment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PendingTreatmentDao {
    /**
     * 获取待处理列表
     * @return
     */
    public List<PendingTreatment> getPendingTreatmentList(@Param("which") int which,
                                                          @Param("user_id") int user_id);

    /**
     * 获取兼职次数
     * @return
     */
    public String getPartNum(@Param("college_user_id") int college_user_id);

    /**
     * 获取累计金额
     * @param work_id
     * @return
     */
    public Double getAccumulatedMoney(@Param("work_id") int work_id);
}
