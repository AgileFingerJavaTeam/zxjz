package com.zxjz.service;

import com.zxjz.dto.excution.IndustryClassificationExcution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IndustryClassificationServiceTest {
    @Autowired
    private IndustryClassificationService industryClassificationService;
    @Test
    public void findListIndustryClassification() throws Exception {
        IndustryClassificationExcution getListIndustry = industryClassificationService.findListIndustryClassification();
        System.out.println("---------");
        System.out.println(getListIndustry);
        System.out.println("---------");
    }

}