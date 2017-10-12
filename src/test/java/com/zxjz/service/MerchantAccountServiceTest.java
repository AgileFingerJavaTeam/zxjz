package com.zxjz.service;

import com.zxjz.dto.excution.MerchantAccountExcution;
import com.zxjz.dto.in.MerchantAccountDto;
import com.zxjz.dto.in.UserByWechatIDDto;
import org.apache.ibatis.annotations.Param;
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
public class MerchantAccountServiceTest {

    @Autowired
    private MerchantAccountService merchantAccountService;

    @Test
    public void findMerchantAccountinfo() throws Exception {
        MerchantAccountDto merchantAccountDto = new MerchantAccountDto();
        merchantAccountDto.setPhone("15022268942");
        merchantAccountDto.setPassword("123qwe");
        MerchantAccountExcution findMerchantAccount = merchantAccountService.findMerchantAccountinfo(merchantAccountDto);
        System.out.println("---------");
        System.out.println(findMerchantAccount);
        System.out.println("---------");
    }

    @Test
    public void findUserByPhone() throws Exception {
        MerchantAccountDto merchantAccountDto = new MerchantAccountDto();
        merchantAccountDto.setPhone("15022268942");
        merchantAccountDto.setVerify_code("1234");
        MerchantAccountExcution findUserByPhone = merchantAccountService.findUserByPhone(merchantAccountDto);
        System.out.println("---------");
        System.out.println(findUserByPhone);
        System.out.println("---------");
    }

    @Test
    public void findUserByWechatID() throws Exception {
        UserByWechatIDDto userByWechatIDDto = new UserByWechatIDDto();
        userByWechatIDDto.setWechat_id("gy2498873793");
        userByWechatIDDto.setHeadimgurl("987654321");
        MerchantAccountExcution findUserByWechatID = merchantAccountService.findUserByWechatID(userByWechatIDDto);
        System.out.println("---------");
        System.out.println(findUserByWechatID);
        System.out.println("---------");
    }

    @Test
    public void findRegistration() throws Exception {
        MerchantAccountDto merchantAccountDto = new MerchantAccountDto();
        merchantAccountDto.setPhone("15022268942");
        merchantAccountDto.setPassword("123qwe");
        merchantAccountDto.setVerify_code("1234");
        MerchantAccountExcution findRegistration = merchantAccountService.findRegistration(merchantAccountDto);
        System.out.println("---------");
        System.out.println(findRegistration);
        System.out.println("---------");
    }

}