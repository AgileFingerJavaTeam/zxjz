package com.zxjz.service;

import com.zxjz.dto.excution.StudentRegistrationExcution;
import com.zxjz.dto.in.StudentRegistrationDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class StudentRegistrationServiceTest {
    @Autowired
    private StudentRegistrationService studentRegistrationService;
    //@Test
    /*public void studentRegistration() throws Exception {
        //StudentRegistrationDto studentRegistrationDto = new StudentRegistrationDto(1,11,1);
        StudentRegistrationExcution studentRegistrationExcution = studentRegistrationService.studentRegistration(studentRegistrationDto);
        System.out.println("-------------------");
        System.out.println(studentRegistrationExcution);
        System.out.println("-------------------");
    }*/

}