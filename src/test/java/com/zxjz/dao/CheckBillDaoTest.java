package com.zxjz.dao;

import com.zxjz.entity.MerchantsBillsInfo;
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

public class CheckBillDaoTest {
    @Autowired
    private CheckBillDao checkBillDao;
    @Test
    public void findBillsInfo() throws Exception {
        List<MerchantsBillsInfo> merchantsBillsInfos = checkBillDao.findBillsInfo(1);
        System.out.println("----------");
        System.out.println(merchantsBillsInfos);
        System.out.println("-----------");
    }

}