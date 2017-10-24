package com.zxjz.dao;

import com.zxjz.entity.StudentWithdraw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentWithdrawDao {
    /**
     *查询学生提现列表
     * @return
     */
    public List<StudentWithdraw> findStudentWithdrawList(@Param("offset")int offset,
                                                          @Param("rows")int rows,
                                                          @Param("withdraw_search")String withdraw_search,
                                                          @Param("selectStatus")String selectStatus);

    /**
     * 查询学生提现条数
     * @return
     */
    public int findStudentWithdrawCount( @Param("withdraw_search")String withdraw_search,
                                          @Param("selectStatus")String selectStatus);

    /**
     * 查询审核时该条学生提现信息
     * @param user_id
     * @param withdraw_num
     * @return
     */
    public StudentWithdraw findStudentWithdrawInfo(@Param("user_id")int user_id,@Param("withdraw_num")int withdraw_num);

    /**
     * 处理当条学生提现信息
     * @param user_id
     * @param withdraw_num
     * @return
     */
    public int updateStudentWithdrawStatus(@Param("user_id")int user_id,@Param("withdraw_num")int withdraw_num,@Param("staff_id")int staff_id);

}
