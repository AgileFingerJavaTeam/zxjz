package com.zxjz.dao;

import com.zxjz.entity.CheckStudentsInfo;
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
public class CheckStudentsDaoTest {


    @Autowired
    private CheckStudentsDao checkStudentsDao;

    @Test
    public void findStuInfoById() throws Exception {
        CheckStudentsInfo checkStudentsInfo = checkStudentsDao.findStuInfoById(3);
        System.out.println("------------------");
        System.out.println(checkStudentsInfo);
        System.out.println("-------------------");
    }
}