package com.zxjz.dao;

import com.zxjz.entity.EnrollJobStatus;
import com.zxjz.entity.QuickSignUp;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public interface EnrollJobStatusInfoDao {
    /**
     * 通过招聘ID，用户ID查兼职状态
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
    public EnrollJobStatus findEnrollJobStatus(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);
    /**
     * 根据用户ID查兼职次数
     * @param student_user_id
     * @return
     */
    public String findJobNumber(int student_user_id);

    /**
     * 兼职次数+1修改兼职次数字段
     * @param FindJobNumber
     * @return
     */
    public int findJobNumberS(String FindJobNumber);

    /**
     * 修改兼职状态
     * @param recruiting_id
     * @param student_user_id
     * @param students_confirmed
     * @return
     */
    public int updateJobStatus(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id, @Param("students_confirmed") String students_confirmed);

    /**
     * 修改兼职状态
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
    public int updateJobStatus1(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);
    /**
     * 根据招聘ID和用户ID查商家是否查看
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
    public String findIsBusinessSee(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);

    /**
     * 根据招聘ID和用户ID查报名表
     * @param recruiting_id
     * @param student_user_id
     * @return
     */
    public QuickSignUp findRepeatSignUp(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id);

    /**
     * 快速报名
     * @param recruiting_id
     * @param student_user_id
     * @param student_name
     * @param contact_phone
     * @param leave_message_merchant
     * @param code
     * @param school
     * @param sex
     * @param registration_time
     * @return
     */
    public int addQuickSignUp(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id, @Param("student_name") String student_name, @Param("contact_phone") String contact_phone, @Param("leave_message_merchant") String leave_message_merchant, @Param("code") String code, @Param("school") String school, @Param("sex") String sex, @Param("registration_time") String registration_time);

    /**
     * 快速报名查发布人ID
     * @param recruiting_id
     * @return
     */
    public String selectInfor(int recruiting_id);

    /**
     * 快速报名插入work表
     * @param selectInfor
     * @param student_user_id
     * @param recruiting_id
     * @return
     */
    public int insertWork(@Param("selectInfor") int selectInfor, @Param("student_user_id") int student_user_id, @Param("recruiting_id") int recruiting_id);

    /**
     * 更新报名人数
     * @param recruiting_id
     * @return
     */
    public int updatePeopleNum(int recruiting_id);
}
