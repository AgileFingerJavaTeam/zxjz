package com.zxjz.dao;

import com.zxjz.entity.StudentRegistration;
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
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StudentRegistrationDaoTest {
    @Autowired
    private StudentRegistrationDao studentRegistrationDao;

    @Test
    public void findStudentRegistration() throws Exception {
             int work_id=1;
             int recruit_id=11;
             int user_id =1;
        StudentRegistration studentRegistration = studentRegistrationDao.findStudentRegistration(work_id,recruit_id,user_id);
        System.out.println("------------------------------------");
        System.out.println(studentRegistration);
        System.out.println("------------------------------------");
    }

}