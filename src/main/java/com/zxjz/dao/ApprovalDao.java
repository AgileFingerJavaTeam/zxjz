package com.zxjz.dao;

import com.zxjz.entity.City;
import com.zxjz.entity.RecruitmentInfoApply;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ApprovalDao {
    /*查询招聘信息*/
    public List<RecruitmentInfoApply> findApprovalList(@Param("bxw_approval_status") String bxw_approval_status,
                                                       @Param("bxw_search_content")String bxw_search_content,
                                                       @Param("sort")String sort,
                                                       @Param("order")String order,
                                                       @Param("offset")int offset,
                                                       @Param("rows")int rows);
    /*查询招聘信息数量*/
    public  int findListCount(@Param("bxw_approval_status") String bxw_approval_status,
                              @Param("bxw_search_content")String bxw_search_content,
                              @Param("sort")String sort,
                              @Param("order")String order);
    /*根据招聘id查看详细信息*/
    public  RecruitmentInfoApply findApprovalByID(int recruiting_id);

    /*审核信息被拒绝*/
    public int updateRefuse(@Param("recruiting_id") int recruiting_id,@Param("releases_user_id") int releases_user_id,@Param("dismissed_reason") String dismissed_reason,@Param("employid")int employid);

    /*审核信息通过*/
    public int updatePass(@Param("recruiting_id") int recruiting_id,@Param("releases_user_id") int releases_user_id,@Param("employid")int employid);

    /*审核通过添加到正式表*/
    public  int addMessage(@Param("recruiting_id")int recruiting_id,
                            @Param("salary_treatment")int salary_treatment,
                            @Param("releases_user_id") int releases_user_id,
                            @Param("post_name")String post_name,
                            @Param("post_classification")int post_classification,
                            @Param("details_page_category")String details_page_category,
                            @Param("work_date")String work_date,
                            @Param("work_time")String work_time,
                            @Param("work_location")String work_location,
                            @Param("position_longitude")String position_longitude,
                            @Param("position_latitude")String position_latitude,
                            @Param("work_content")String work_content,
                            @Param("settlement_method") String settlement_method,
                            @Param("commission")String commission,
                            @Param("benefits")String benefits,
                            @Param("gender_requirements")String gender_requirements,
                            @Param("recruitment")int recruitment,
                            @Param("people_num")int people_num,
                            @Param("hiring_expiration_date")String hiring_expiration_date,
                            @Param("city")int city
                           );


}
