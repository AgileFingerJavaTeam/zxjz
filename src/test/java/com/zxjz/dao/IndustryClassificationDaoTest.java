package com.zxjz.dao;

import com.zxjz.entity.IndustryClassification;
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
public class IndustryClassificationDaoTest {
    @Autowired
    private IndustryClassificationDao industryClassificationDao;
    @Test
    public void getListIndustryClassification() throws Exception {
        /*int offset = 20;
        int rows = 1;*/
        List<IndustryClassification> getListIndustryClassification = industryClassificationDao.getListIndustryClassification();
        System.out.println("----------");
        System.out.println(getListIndustryClassification);
        System.out.println("----------");
    }

}