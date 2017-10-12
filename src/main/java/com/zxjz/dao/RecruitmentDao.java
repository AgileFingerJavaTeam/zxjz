package com.zxjz.dao;

import com.zxjz.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public interface RecruitmentDao {


    /*public int addRecruitment(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") double salary_treatment, @Param("commission") double commission, @Param("benefits") double benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification);

    public List<CityList> findCityList();

    public int updateCtiy(@Param("city_id") int city_id, @Param("recruiting_id") int recruiting_id);
*/
    public  int addPsostJob(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    public Recruitment findRecruID(int recruiting_id);
    public  int updateJobcopy(int recruiting_id);
    public  int addPostJobcopy(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    public  Recruitment findStatus(int recruiting_id);
    public  int updateStatus(@Param("status_time") String status_time, @Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city,@Param("status_result")String status_result,@Param("dismissed_reason")String dismissed_reason,@Param("recruiting_id") int recruiting_id);
    public  int updateStatusC(@Param("status_time") String status_time, @Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city,@Param("status_result")String status_result,@Param("dismissed_reason")String dismissed_reason,@Param("recruiting_id") int recruiting_id);
    public  int addData(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    public  int updatejob(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    public  int updatepostjob(int recruiting_id);
    public String status(int recruiting_id);
    public  int updataStatus(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") double salary_treatment, @Param("commission") double commission, @Param("benefits") double benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    public int insertData(@Param("user_id") int user_id, @Param("post_name") String post_name, @Param("settlement_method") String settlement_method, @Param("salary_treatment") int salary_treatment, @Param("commission") String commission, @Param("benefits") String benefits, @Param("position_longitude") String position_longitude, @Param("position_latitude") String position_latitude, @Param("work_location") String work_location, @Param("work_date") String work_date, @Param("work_time") String work_time, @Param("recruitment") int recruitment, @Param("gender_requirements") String gender_requirements, @Param("work_content") String work_content, @Param("hiring_expiration_date") String hiring_expiration_date, @Param("leader") String leader, @Param("leader_phone") String leader_phone, @Param("post_classification") int post_classification, @Param("city") int city);
    /**
     * 查看是否设置支付密码
     * @param user_id
     * @return
     */
    public IsSetPassword findIsPayPswByUserId(int user_id);


    public int updatePayPswByUserId(@Param("pay_psw") String pay_psw, @Param("not_need_psw_period") int not_need_psw_period, @Param("is_need_psw") int is_need_psw, @Param("user_id") int user_id);
    public int savePayPswByUserId(@Param("pay_psw") String pay_psw, @Param("not_need_psw_period") int not_need_psw_period, @Param("is_need_psw") int is_need_psw, @Param("user_id") int user_id);

    public List<MerchantFundsCurrentAccount> findListTradingRecord(int user_id);
    public MerchantFundsCurrentAccount findTradingRecord(int student_id);
    public MerchantFundsCurrentAccount findTradingRecords(int work_id);
    public MerchantFundsCurrentAccount findMerchantRecharge(@Param("references_the_bill_id") int references_the_bill_id, @Param("references_the_internal_serial_number1") int references_the_internal_serial_number1);
    public MerchantFundsCurrentAccount findMerchantTX(@Param("references_the_bill_id") int references_the_bill_id, @Param("references_the_internal_serial_number1") int references_the_internal_serial_number1);

    public List<CheckBill> findListCheckBill(@Param("student_user_id") int student_user_id, @Param("user_id") int user_id);
}
