package com.zxjz.dao;

import com.zxjz.entity.MerchantsAccount;
import com.zxjz.entity.MerchantsInfo;
import com.zxjz.entity.MerchantsUpgrade;
import org.apache.ibatis.annotations.Param;

public interface MerchantsInfoDao {
    /**
     * 通过ID查询商户信息
     * @param user_id
     * @return
     */
    public MerchantsInfo findEmpolyerInfoById(@Param("user_id") int user_id);

    /**
     * 通过UserId变更负责人信息
     * @param head
     * @param job
     * @param phone
     * @return
     */
    public int updateHeadInfoByUserId(@Param("head") String head, @Param("job") String job, @Param("phone") String phone, @Param("user_id") int user_id);

    /**
     * 根据ID更新员工是否爽约状态
     * @param id
     * @return
     */
    public int UpdateStateById(@Param("id") int id);

    /**
     * 根据ID获取招聘ID和学生ID
     * @param id
     * @return
     */
    public MerchantsAccount findRecruitingIdAndStudentIdById(@Param("id") int id);

    /**
     * 根据学生ID和招聘ID把工作结束
     * @param recriut_id
     * @param student_user_id
     * @return
     */
    public int updateWorkBaseInfo(@Param("recriut_id") int recriut_id, @Param("student_user_id") int student_user_id);

    /**
     * 根据学生ID更新学生爽约次数
     * @param student_user_id
     * @return
     */
    public int updateStudentMissNumber(@Param("student_user_id") int student_user_id);

    /**
     * 申请VIP商户：通过ID添加一条商户申请信息
     * @param user_id
     * @return
     */
    public int addADataById(@Param("user_id") int user_id);

    public MerchantsUpgrade findUserById(@Param("user_id") int user_id);
}
