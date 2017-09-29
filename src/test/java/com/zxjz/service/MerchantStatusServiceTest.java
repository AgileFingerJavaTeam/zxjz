package com.zxjz.service;

import com.zxjz.dto.excution.MerchantStatusExcution;
import com.zxjz.dto.in.MerchantStatusDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class MerchantStatusServiceTest {
    @Autowired
    private MerchantStatusService merchantStatusService;
    @Test
    public void findMerchantStatus() throws Exception {
        MerchantStatusDto merchantStatusDto = new MerchantStatusDto();
        merchantStatusDto.setUser_id(2);
        merchantStatusDto.setWhich("1");
        MerchantStatusExcution merchantStatusExcution=merchantStatusService.findMerchantStatus(merchantStatusDto);
        System.out.println("-----------------------");
        System.out.println(merchantStatusExcution);
        System.out.println("-----------------------");
    }

}