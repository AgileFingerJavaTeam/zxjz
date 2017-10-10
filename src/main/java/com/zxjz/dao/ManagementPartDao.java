package com.zxjz.dao;

import com.zxjz.entity.ManagementPart;

import java.util.List;

public interface ManagementPartDao {
    /**
     * 获取状态位正在进行和暂停的数据
     * @param user_id
     * @return
     */
    public List<ManagementPart> getUnderWayInfor(int user_id);

    /**
     *  获取状态位待审核的数据
     * @param user_id
     * @return
     */
    public List<ManagementPart> getToAudit(int user_id);
    /**
     *  获取状态位已结束的数据
     * @param user_id
     * @return
     */
    public List<ManagementPart> getIsOver(int user_id);
    /**
     *   获取状态位草稿箱的数据
     * @param user_id
     * @return
     */
    public List<ManagementPart> getHasBeenRejected(int user_id);

    /**
     *   获取状态位已结束的数据
     */
    public List<ManagementPart> getDraftBox(int user_id);

    /**
     *  暂停修改进行
     */
    public int updatePause(int recruiting_id);

    /**
     *  进行修改暂停
     */
    public int updateFor(int recruiting_id);

    /**
     *  审核未通过
     */
    public int updateReject(int recruiting_id);

    /**
     * 已结束
     */
    public int updateIsOver(int recruiting_id);

}
