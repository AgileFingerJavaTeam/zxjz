package com.zxjz.dao;

import com.zxjz.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserInfoDaoTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void getUserInfoByName() throws Exception {
        String username = "amy";
        UserInfo userInfo = userInfoDao.getUserInfoByName(username);
        System.out.println("---------");
        System.out.println(userInfo);
        System.out.println("---------");
    }

}