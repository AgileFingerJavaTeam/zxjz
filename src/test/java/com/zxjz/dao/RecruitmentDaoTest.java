package com.zxjz.dao;

import com.zxjz.entity.CheckBill;
import com.zxjz.entity.IsSetPassword;
import com.zxjz.entity.MerchantFundsCurrentAccount;
import com.zxjz.entity.Recruitment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RecruitmentDaoTest {
    @Autowired
    private  RecruitmentDao recruitmentDao;
    @Test
    public void addPsostJob() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        int addPsostJob=recruitmentDao.addPsostJob(user_id,post_name,settlement_method,salary_treatment,commission,benefits, position_longitude,position_latitude,work_location,work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader,leader_phone,post_classification, city);
        System.out.println(addPsostJob);
    }

    @Test
    public void findRecruID() throws Exception {
        int recruiting_id=2;
        Recruitment findRecruID=recruitmentDao.findRecruID(recruiting_id);
        System.out.println(findRecruID);
    }

    @Test
    public void updateJobcopy() throws Exception {
        int recruiting_id=7;
        int updateJobcopy=recruitmentDao.updateJobcopy(recruiting_id);
        System.out.println(updateJobcopy);
    }

    @Test
    public void addPostJobcopy() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        int addPostJobcopy=recruitmentDao.addPostJobcopy(user_id,post_name,settlement_method,salary_treatment,commission,benefits, position_longitude,position_latitude,work_location,work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader,leader_phone,post_classification, city);
        System.out.println(addPostJobcopy);
    }

    @Test
    public void findStatus() throws Exception {
        int recruiting_id=2;
        Recruitment findStatus=recruitmentDao.findStatus(recruiting_id);
        System.out.println(findStatus);
    }

    @Test
    public void updateStatus() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        String status_time="2017-11-11";
        String status_result="草稿";
        String dismissed_reason="无";
        int recruiting_id=6;
        int updateStatus=recruitmentDao.updateStatus(status_time,user_id, post_name,settlement_method,salary_treatment,commission,benefits, position_longitude, position_latitude, work_location, work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader, leader_phone,post_classification, city,status_result,dismissed_reason,recruiting_id);
        System.out.println(updateStatus);
    }

    @Test
    public void updateStatusC() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        String status_time="2017-11-11";
        String status_result="草稿";
        String dismissed_reason="无";
        int recruiting_id=6;
        int updateStatusC=recruitmentDao.updateStatusC(status_time,user_id, post_name,settlement_method,salary_treatment,commission,benefits, position_longitude, position_latitude, work_location, work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader, leader_phone,post_classification, city,status_result,dismissed_reason,recruiting_id);
        System.out.println(updateStatusC);
    }

    @Test
    public void addData() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        int addData=recruitmentDao.addData(user_id,post_name,settlement_method,salary_treatment,commission,benefits, position_longitude,position_latitude,work_location,work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader,leader_phone,post_classification, city);
        System.out.println(addData);
    }

    @Test
    public void updatejob() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        int updatejob=recruitmentDao.updatejob(user_id,post_name,settlement_method,salary_treatment,commission,benefits, position_longitude,position_latitude,work_location,work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader,leader_phone,post_classification, city);
        System.out.println(updatejob);
    }

    @Test
    public void updatepostjob() throws Exception {
        int recruiting_id=3;
        int updatepostjob=recruitmentDao.updatepostjob(recruiting_id);
        System.out.println(updatepostjob);
    }


    @Test
    public void updataStatus() throws Exception {

    }

    @Test
    public void insertData() throws Exception {
        int user_id=2;
        String post_name="派发传单";
        String settlement_method="周结";
        int salary_treatment=1;
        String commission="无";
        String benefits="包食宿";
        String position_longitude="103.1";
        String position_latitude="33.2";
        String work_date="9天";
        String work_time="8小时";
        String work_location="海河畔";
        String gender_requirements="女";
        int recruitment=20;
        String work_content="打字";
        String hiring_expiration_date="2018-01-01";
        String leader="自己人 ";
        String leader_phone="222";
        int post_classification=2;
        int city=2;
        int insertData=recruitmentDao.insertData(user_id,post_name,settlement_method,salary_treatment,commission,benefits, position_longitude,position_latitude,work_location,work_date,work_time,recruitment,gender_requirements,work_content,hiring_expiration_date,leader,leader_phone,post_classification, city);
        System.out.println(insertData);
    }

    @Test
    public void findIsPayPswByUserId() throws Exception {
        int user_id=2;
        IsSetPassword findIsPayPswByUserId=recruitmentDao.findIsPayPswByUserId(user_id);
        System.out.println(findIsPayPswByUserId);
    }

    @Test
    public void updatePayPswByUserId() throws Exception {
        String pay_psw="1111";
        int not_need_psw_period=0 ;
        int is_need_psw=0;
        int user_id=2;
        int updatePayPswByUserId=recruitmentDao.updatePayPswByUserId(pay_psw,not_need_psw_period,is_need_psw,user_id);
        System.out.println(updatePayPswByUserId);
    }

    @Test
    public void savePayPswByUserId() throws Exception {
        String pay_psw="1111";
        int not_need_psw_period=0 ;
        int is_need_psw=0;
        int user_id=3;
        int savePayPswByUserId=recruitmentDao.savePayPswByUserId(pay_psw,not_need_psw_period,is_need_psw,user_id);
        System.out.println(savePayPswByUserId);
    }

    @Test
    public void findListTradingRecord() throws Exception {
        int user_id=2;
        List<MerchantFundsCurrentAccount> findListTradingRecord= (List<MerchantFundsCurrentAccount>) recruitmentDao.findListTradingRecord(user_id);
        System.out.println(findListTradingRecord);
    }

    @Test
    public void findTradingRecord() throws Exception {
        int student_id=6;
        MerchantFundsCurrentAccount findTradingRecord=recruitmentDao.findTradingRecord(student_id);
        System.out.println(findTradingRecord);
    }

    @Test
    public void findTradingRecords() throws Exception {
        int work_id=3;
        MerchantFundsCurrentAccount findTradingRecords=recruitmentDao.findTradingRecords(work_id);
        System.out.println(findTradingRecords);
    }

    @Test
    public void findMerchantRecharge() throws Exception {
        int references_the_bill_id=2;
        int references_the_internal_serial_number1=2;
        MerchantFundsCurrentAccount findMerchantRecharge=recruitmentDao.findMerchantRecharge(references_the_bill_id,references_the_internal_serial_number1);
        System.out.println(findMerchantRecharge);

    }

    @Test
    public void findMerchantTX() throws Exception {
        int references_the_bill_id=2;
        int references_the_internal_serial_number1=2;
        MerchantFundsCurrentAccount findMerchantTX=recruitmentDao.findMerchantTX(references_the_bill_id,references_the_internal_serial_number1);
        System.out.println(findMerchantTX);
    }

    @Test
    public void findListCheckBill() throws Exception {
        int user_id=5;
        int student_user_id=6;
        List<CheckBill> findListCheckBill= (List<CheckBill>) recruitmentDao.findListCheckBill(student_user_id,user_id);
        System.out.println(findListCheckBill);

    }

}