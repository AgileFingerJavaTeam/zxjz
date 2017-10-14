package com.zxjz.service;

import com.zxjz.dto.excution.RecruitmentExcution;
import com.zxjz.dto.in.CheckBillDto;
import com.zxjz.dto.in.PaypsdDto;
import com.zxjz.dto.in.RecruitmentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class RecruitmentServiceTest {
    @Autowired
    private RecruitmentService recruitmentService;
    @Test
    public void postjob() throws Exception {
        RecruitmentDto recruitmentDto=new RecruitmentDto();
        recruitmentDto.setUser_id(5);
        recruitmentDto.setPost_name("快手兼职 ");
        recruitmentDto.setSettlement_method("日结");
        recruitmentDto.setSalary_treatment(1);
        recruitmentDto.setCommission("piaoliang");
        recruitmentDto.setBenefits("美女多");
        recruitmentDto.setPosition_longitude("107.321");
        recruitmentDto.setPosition_latitude("33.333");
        recruitmentDto.setWork_date("10天");
        recruitmentDto.setWork_time("8小时");
        recruitmentDto.setWork_location("滨江道");
        recruitmentDto.setRecruitment(11);
        recruitmentDto.setGender_requirements("女");
        recruitmentDto.setWork_content("打字");
        recruitmentDto.setHiring_expiration_date("2017-11-11");
        recruitmentDto.setLeader("bieren");
        recruitmentDto.setLeader_phone("9998877");
        recruitmentDto.setPost_classification(2);
        recruitmentDto.setCity(1);
        RecruitmentExcution recruitmentExcution=recruitmentService.postjob(recruitmentDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void postjobcopy() throws Exception {
        RecruitmentDto recruitmentDto=new RecruitmentDto();
        recruitmentDto.setUser_id(5);
        recruitmentDto.setPost_name("快手兼职 ");
        recruitmentDto.setSettlement_method("日结");
        recruitmentDto.setSalary_treatment(1);
        recruitmentDto.setCommission("piaoliang");
        recruitmentDto.setBenefits("美女多");
        recruitmentDto.setPosition_longitude("107.321");
        recruitmentDto.setPosition_latitude("33.333");
        recruitmentDto.setWork_date("10天");
        recruitmentDto.setWork_time("8小时");
        recruitmentDto.setWork_location("滨江道");
        recruitmentDto.setRecruitment(11);
        recruitmentDto.setGender_requirements("女");
        recruitmentDto.setWork_content("打字");
        recruitmentDto.setHiring_expiration_date("2017-11-11");
        recruitmentDto.setLeader("bieren");
        recruitmentDto.setLeader_phone("9998877");
        recruitmentDto.setPost_classification(2);
        recruitmentDto.setCity(1);
        RecruitmentExcution recruitmentExcution=recruitmentService.postjobcopy(recruitmentDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void postfailure() throws Exception {
        RecruitmentDto recruitmentDto=new RecruitmentDto();
        recruitmentDto.setUser_id(5);
        recruitmentDto.setPost_name("快手兼职 ");
        recruitmentDto.setSettlement_method("日结");
        recruitmentDto.setSalary_treatment(1);
        recruitmentDto.setCommission("piaoliang");
        recruitmentDto.setBenefits("美女多");
        recruitmentDto.setPosition_longitude("107.321");
        recruitmentDto.setPosition_latitude("33.333");
        recruitmentDto.setWork_date("10天");
        recruitmentDto.setWork_time("8小时");
        recruitmentDto.setWork_location("滨江道");
        recruitmentDto.setRecruitment(11);
        recruitmentDto.setGender_requirements("女");
        recruitmentDto.setWork_content("打字");
        recruitmentDto.setHiring_expiration_date("2017-11-11");
        recruitmentDto.setLeader("bieren");
        recruitmentDto.setLeader_phone("9998877");
        recruitmentDto.setPost_classification(2);
        recruitmentDto.setCity(1);
        recruitmentDto.setStatus_time("2017-11-11");
        recruitmentDto.setStatus_result("草稿");
        recruitmentDto.setDismissed_reason("bukeyi");
        recruitmentDto.setRecruiting_id(6);
        RecruitmentExcution recruitmentExcution=recruitmentService.postfailure(recruitmentDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void editpostjobcopy() throws Exception {
        RecruitmentDto recruitmentDto=new RecruitmentDto();
        recruitmentDto.setUser_id(5);
        recruitmentDto.setPost_name("快手兼职 ");
        recruitmentDto.setSettlement_method("日结");
        recruitmentDto.setSalary_treatment(1);
        recruitmentDto.setCommission("piaoliang");
        recruitmentDto.setBenefits("美女多");
        recruitmentDto.setPosition_longitude("107.321");
        recruitmentDto.setPosition_latitude("33.333");
        recruitmentDto.setWork_date("10天");
        recruitmentDto.setWork_time("8小时");
        recruitmentDto.setWork_location("滨江道");
        recruitmentDto.setRecruitment(11);
        recruitmentDto.setGender_requirements("女");
        recruitmentDto.setWork_content("打字");
        recruitmentDto.setHiring_expiration_date("2017-11-11");
        recruitmentDto.setLeader("bieren");
        recruitmentDto.setLeader_phone("9998877");
        recruitmentDto.setPost_classification(2);
        recruitmentDto.setCity(1);
        recruitmentDto.setStatus_time("2017-11-11");
        recruitmentDto.setStatus_result("草稿");
        recruitmentDto.setDismissed_reason("bukeyi");
        recruitmentDto.setRecruiting_id(6);
        RecruitmentExcution recruitmentExcution=recruitmentService.editpostjobcopy(recruitmentDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void editJob() throws Exception {
        RecruitmentDto recruitmentDto=new RecruitmentDto();
        recruitmentDto.setUser_id(5);
        recruitmentDto.setPost_name("快手兼职 ");
        recruitmentDto.setSettlement_method("日结");
        recruitmentDto.setSalary_treatment(1);
        recruitmentDto.setCommission("piaoliang");
        recruitmentDto.setBenefits("美女多");
        recruitmentDto.setPosition_longitude("107.321");
        recruitmentDto.setPosition_latitude("33.333");
        recruitmentDto.setWork_date("10天");
        recruitmentDto.setWork_time("8小时");
        recruitmentDto.setWork_location("滨江道");
        recruitmentDto.setRecruitment(11);
        recruitmentDto.setGender_requirements("女");
        recruitmentDto.setWork_content("打字");
        recruitmentDto.setHiring_expiration_date("2017-11-11");
        recruitmentDto.setLeader("bieren");
        recruitmentDto.setLeader_phone("9998877");
        recruitmentDto.setPost_classification(2);
        recruitmentDto.setCity(1);
        recruitmentDto.setStatus_time("2017-11-11");
        recruitmentDto.setStatus_result("草稿");
        recruitmentDto.setDismissed_reason("bukeyi");
        recruitmentDto.setRecruiting_id(3);
        RecruitmentExcution recruitmentExcution=recruitmentService.editJob(recruitmentDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void setpaypsd() throws Exception {
        PaypsdDto paypsdDto=new PaypsdDto();
        paypsdDto.setIs_need_psw(0);
        paypsdDto.setNot_need_psw_period(0);
        paypsdDto.setPay_psw("9999");
        paypsdDto.setUser_id(2);
        RecruitmentExcution recruitmentExcution=recruitmentService.setpaypsd(paypsdDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void tradingRecord() throws Exception {
        PaypsdDto paypsdDto=new PaypsdDto();

        paypsdDto.setUser_id(4);

        RecruitmentExcution recruitmentExcution=recruitmentService.tradingRecord(paypsdDto);
        System.out.println(recruitmentExcution);
    }

    @Test
    public void checkBill() throws Exception {
       CheckBillDto checkBillDto=new CheckBillDto();
       checkBillDto.setStudent_user_id(6);
       checkBillDto.setUser_id(5);
        RecruitmentExcution recruitmentExcution=recruitmentService.checkBill(checkBillDto);
        System.out.println(recruitmentExcution);
    }

}