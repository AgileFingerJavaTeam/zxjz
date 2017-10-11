package com.zxjz.dao;

import com.zxjz.entity.MerchantAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecurityPositionDaoTest {
    @Autowired
    private SecurityPositionDao securityPositionDao;
    @Test
    public void findListMarchantName() throws Exception {
         List<MerchantAccount> list = securityPositionDao.findListMarchantName();
        System.out.println("--------------");
        System.out.println(list);
    }
    @Test
    public void findSecurityPositionSecurity1() throws Exception {
        Map map = securityPositionDao.findSecurityPositionSecurity1(1);
        System.out.println("--------------");
        System.out.println(map);
    }


}