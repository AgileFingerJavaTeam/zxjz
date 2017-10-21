package com.zxjz.dao;

import com.zxjz.entity.JobDetails;
import com.zxjz.entity.SystemParameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemParameterDao {
    /**
     * 通过参数名去查询参数信息
     * @param parameter_name
     * @return
     */
    public SystemParameter findSystemInfoByParameterName(String parameter_name);

    /**
     * 商家对学生新增一条评价
     * @param user_id
     * @param job_id
     * @param merchant_id
     * @param words_evaluate
     * @param descriptive_corre
     * @param punctuality_idea
     * @param conscientiousness
     * @param working_ability
     * @param compre_evaluation
     * @return
     */
    public int addEvaluate(@Param("user_id") int user_id, @Param("job_id") int job_id, @Param("merchant_id") int merchant_id, @Param("words_evaluate") String words_evaluate, @Param("descriptive_corre") double descriptive_corre, @Param("punctuality_idea") double punctuality_idea, @Param("conscientiousness") double conscientiousness, @Param("working_ability") double working_ability, @Param("compre_evaluation") double compre_evaluation);

    public int addEvaluateInStudentTable(@Param("user_id") int user_id, @Param("descriptive_corre") double descriptive_corre, @Param("punctuality_idea") double punctuality_idea, @Param("conscientiousness") double conscientiousness, @Param("working_ability") double working_ability, @Param("compre_evaluation") double compre_evaluation);

    /**
     * 根据招聘ID查询职位状态
     * @param recruiting_id
     * @return
     */
    public JobDetails findStatusResult(@Param("recruiting_id") int recruiting_id);

    /**
     * 查询已通过审核的职位详情
     * @param recruiting_id
     * @param user_id
     * @return
     */
    public JobDetails findPassedJobDetail(@Param("recruiting_id") int recruiting_id, @Param("user_id") int user_id);

    /**
     * 查询除审核之外的职位详情
     * @param recruiting_id
     * @param user_id
     * @return
     */
    public JobDetails findOtherJobDetail(@Param("recruiting_id") int recruiting_id, @Param("user_id") int user_id);

    /**
     * 查询系统参数
     * @param rows
     * @param offset
     * @return
     */
    public List<SystemParameter> findSystemPatameter(@Param("rows") int rows, @Param("offset") int offset, @Param("srt_search_content") String srt_search_content);

    /**
     * 查询系统参数条数
     * @param srt_search_content
     * @return
     */
    public int findSysParameterCount(@Param("srt_search_content") String srt_search_content);

    /**
     * 新增一条系统参数
     * @param serial_number
     * @param parameter_name
     * @param parameter_description
     * @param parameter
     * @return
     */
    public int addSystemParameter(@Param("serial_number")String serial_number,@Param("parameter_name")String parameter_name,@Param("parameter_description")String parameter_description,@Param("parameter")String parameter);
    /**
     * 通过Id查询当前参数信息
     * @param id
     * @return
     */
    public SystemParameter findSystemParameterInfoById(@Param("id")int id);

    /**
     * 编辑一条系统参数
     * @param parameter_id
     * @param serial_number
     * @param parameter_name
     * @param parameter_description
     * @param parameter
     * @return
     */
    public int updateSystemParameter(@Param("parameter_id")int parameter_id,@Param("serial_number")String serial_number,@Param("parameter_name")String parameter_name,@Param("parameter_description")String parameter_description,@Param("parameter")String parameter);

    /**
     * 删除一条系统参数
     * @param parameter_id
     * @return
     */
    public int delSystemParameter(@Param("parameter_id")int parameter_id);
}
