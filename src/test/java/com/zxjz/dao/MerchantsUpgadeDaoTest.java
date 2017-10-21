package com.zxjz.dao;

import com.zxjz.entity.MerchantsUpgrade;
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
public class MerchantsUpgadeDaoTest {


    @Autowired
    private MerchantsUpgadeDao merchantsUpgadeDao;
    @Test
    public void findApplyVipList() throws Exception {
        List<MerchantsUpgrade> jobList = merchantsUpgadeDao.findApplyVipList(null,null,0,20);
        System.out.println("--------------");
        System.out.println(jobList);
        System.out.println("---------------");
    }


    @Test
    public void findAcceptEmployer() throws Exception {
        String AE = merchantsUpgadeDao.findAcceptEmployer(4);
        System.out.println("--------------");
        System.out.println(AE);
        System.out.println("---------------");
    }

    @Test
    public void findOperatingEmployer() throws Exception {
    }
}