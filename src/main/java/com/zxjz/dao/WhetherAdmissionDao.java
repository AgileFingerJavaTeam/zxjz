package com.zxjz.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface WhetherAdmissionDao {

    public int updateAdmission(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id, @Param("hired") String hired, @Param("after_confirmation") String after_confirmation);

    public int updateAdmissionT(@Param("recruiting_id") int recruiting_id, @Param("student_user_id") int student_user_id, @Param("hired") String hired);
}
