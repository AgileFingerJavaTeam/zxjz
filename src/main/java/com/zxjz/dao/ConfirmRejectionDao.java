package com.zxjz.dao;

import com.zxjz.entity.ConfirmRejection;

public interface ConfirmRejectionDao {
    /**
     * 商家录用学生接口
     * hired 是否录取（是/否）
     * @return
     */
    public int updateConReject(int recruiting_id);

    /**
     * 查询总人数和已经录用人数
     * @return
     */
    public ConfirmRejection getConRejectNum(int recruiting_id);

    /**
     * 修改学生录用时间
     * @param recruiting_id
     * @return
     */
    public int updataEmployTime(int recruiting_id);

    /**
     * 查询工作ID
     * @param recruiting_id
     * @return
     */
    public int findRecruId(int recruiting_id);

    /**
     * 修改 已经报名人数-1 已经录用人数+1
     * @param id
     * @return
     */
    public int updateNum(int id);
}
