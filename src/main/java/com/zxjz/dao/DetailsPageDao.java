package com.zxjz.dao;

import com.zxjz.entity.DetailsPage;

public interface DetailsPageDao {
    /**
     * 大学生个人信息
     * @return
     */
    public DetailsPage getDetailsPage(int id);

    /**
     * 评论条数
     * @param user_id
     * @return
     */
    public int getCommentariesNum(int user_id);
    /**
     *
     */
    public String getIsOver(int work_id);
}
