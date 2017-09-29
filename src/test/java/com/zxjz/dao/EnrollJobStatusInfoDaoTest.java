package com.zxjz.dao;

import com.zxjz.entity.EnrollJobStatus;
import com.zxjz.entity.QuickSignUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class EnrollJobStatusInfoDaoTest {
    @Autowired
    private EnrollJobStatusInfoDao enrollJobStatusInfoDao;
    @Test
    public void findEnrollJobStatus() throws Exception {
          int recruiting_id = 3;
          int student_user_id = 3;
        EnrollJobStatus findEnrollJobStatus = enrollJobStatusInfoDao.findEnrollJobStatus(recruiting_id,student_user_id);
        System.out.println("-------------------------------");
        System.out.println(findEnrollJobStatus);
        System.out.println("-------------------------------");
    }

    @Test
    public void FindJobNumber() throws Exception {
        int student_user_id = 1;
        String findJobNumber = enrollJobStatusInfoDao.findJobNumber(student_user_id);
        System.out.println("-------------------------------");
        System.out.println(findJobNumber);
        System.out.println("-------------------------------");
    }


    @Test
    public void IsBusinessSee() throws Exception {
        int recruiting_id = 11;
        int student_user_id = 1;
        String isBusinessSee = enrollJobStatusInfoDao.findIsBusinessSee(recruiting_id,student_user_id);
        System.out.println("-------------------------------");
        System.out.println(isBusinessSee);
        System.out.println("-------------------------------");
    }

    @Test
    public void FindRepeatSignUp() throws Exception {
        int recruiting_id = 3;
        int student_user_id = 3;
        QuickSignUp isBusinessSee = enrollJobStatusInfoDao.findRepeatSignUp(recruiting_id,student_user_id);
        System.out.println("-------------------------------");
        System.out.println(isBusinessSee);
        System.out.println("-------------------------------");
    }
}