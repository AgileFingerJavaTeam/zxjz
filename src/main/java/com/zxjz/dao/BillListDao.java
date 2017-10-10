package com.zxjz.dao;

import com.zxjz.entity.BillList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillListDao {
    /**
     * 获取账单列表
     * @return
     */
    public List<BillList> getBillList(@Param("work_id") int work_id,
                                      @Param("college_user_id") int college_user_id,
                                      @Param("recruiting_id") int recruiting_id);
}
