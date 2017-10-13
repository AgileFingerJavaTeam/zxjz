package com.zxjz.dao;

import com.zxjz.entity.CheckStudentsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckStudentsDao {
    /**
     * 查询认证学生列表
     * @param offset
     * @param rows
     * @param check_state
     * @param srt_searchStu_content
     * @return
     */
    public List<CheckStudentsInfo> findStudentsCheckInfo(@Param("offset")int offset,@Param("rows")int rows,@Param("check_state")int check_state,@Param("srt_searchStu_content")String srt_searchStu_content,@Param("srt_filtrate")String srt_filtrate);

    /**
     * 查询认证学生条数
     * @param srt_filtrate
     * @param srt_searchStu_content
     * @return
     */
    public int findStuCertificationCount(@Param("srt_filtrate")String srt_filtrate,@Param("srt_searchStu_content")String srt_searchStu_content);

    /**
     * 查询当前审核学生信息
     * @param id
     * @return
     */
    public CheckStudentsInfo findStuInfoById(@Param("id")int id);

    /**
     * 审核驳回（更新审核状态）
     * @param user_id
     * @return
     */
    public int refuseStudent(@Param("user_id")int user_id);

    /**
     * 审核通过（更新审核状态）
     * @param user_id
     * @return
     */
    public int passStudent(@Param("user_id")int user_id);
}
