package com.zxjz.dao;

import com.zxjz.entity.UserCountInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserCountInfoDaoTest {
    @Autowired
    private UserCountInfoDao userCountInfoDao;
    @Test
    public void getUserCountInfo() throws Exception {
        String phone = "15022268942";
        String password = "123qwe";
        UserCountInfo getUserCountInfo = userCountInfoDao.getUserCountInfo(phone,password);
        System.out.println("----------");
        System.out.println(getUserCountInfo);
    }

}