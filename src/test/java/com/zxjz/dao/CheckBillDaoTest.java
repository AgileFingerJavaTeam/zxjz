package com.zxjz.dao;

import com.zxjz.entity.MerchantPayforTerrace;
import com.zxjz.entity.MerchantWithdrawInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CheckBillDaoTest {
    @Autowired
    private CheckBillDao checkBillDao;
    @Test
    public void findWithdrawInfoById() throws Exception {
        MerchantWithdrawInfo info = checkBillDao.findWithdrawInfoById(2,2);
        System.out.println(info);
    }
    @Test
    public void findCostInfoById() throws Exception {
        MerchantPayforTerrace info = checkBillDao.findCostInfoById(2,4);
        System.out.println(info);
    }

}