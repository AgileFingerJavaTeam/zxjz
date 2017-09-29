package com.zxjz.dao;

import com.zxjz.entity.MerchantStatusOne;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MerchantStatusDaoTest {
    @Autowired
    private MerchantStatusDao merchantStatusDao;
    @Test
    public void findMerchantStatusOne() throws Exception {
          int user_id = 2;
          String which = "1";
        List<MerchantStatusOne> merchantStatusOneList = merchantStatusDao.findMerchantStatusOne(user_id);
        System.out.println("---------");
        System.out.println(merchantStatusOneList);
        System.out.println("---------");
    }

}