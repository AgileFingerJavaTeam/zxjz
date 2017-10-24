package com.zxjz.dao;

import com.zxjz.entity.StudentWithdraw;
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
public class StudentWithdrawDaoTest {
    @Autowired
    private StudentWithdrawDao studentWithdrawDao;
    @Test
    public void findStudentWithdrawList() throws Exception {
        List<StudentWithdraw> studentWithdrawList = studentWithdrawDao.findStudentWithdrawList(0,20,null,"");
        System.out.println(studentWithdrawList);
    }
    @Test
    public void findStudentWithdrawCount() throws Exception {
        int count = studentWithdrawDao.findStudentWithdrawCount(null,null);
        System.out.println(count);
    }
    @Test
    public void findStudentWithdrawInfo() throws Exception {
        StudentWithdraw studentWithdraw = studentWithdrawDao.findStudentWithdrawInfo(6,1);
        System.out.println(studentWithdraw);
    }
    @Test
    public void updateStudentWithdrawStatus() throws Exception {
        int isUpdate = studentWithdrawDao.updateStudentWithdrawStatus(6,3,6);
        System.out.println(isUpdate);
    }

}