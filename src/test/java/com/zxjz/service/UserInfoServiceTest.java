package com.zxjz.service;

import com.zxjz.dto.excution.UserInfoExcution;
import com.zxjz.dto.in.UserInfoDto;
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
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void login() throws Exception {
        UserInfoDto userInfoDto = new UserInfoDto("amy","111");
        UserInfoExcution userInfoExcution = userInfoService.login(userInfoDto);
        System.out.println("---------");
        System.out.println(userInfoExcution);
        System.out.println("---------");
    }

}