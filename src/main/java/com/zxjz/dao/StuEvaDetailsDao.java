package com.zxjz.dao;

import com.zxjz.entity.StuEvaDetails;
import com.zxjz.entity.StuPersonal;

public interface StuEvaDetailsDao {

    /**
     * 获取学生总评价
     * @return
     */
    public StuPersonal getStuPersonal(int user_id);

    /**
     * 获取学生评价详情
     * @return
     */
    public StuEvaDetails getStuEvaDetails(int user_id);
}
