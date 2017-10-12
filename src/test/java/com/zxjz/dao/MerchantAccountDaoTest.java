package com.zxjz.dao;

import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.entity.MerchantApprovalStatusInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MerchantAccountDaoTest {

    @Autowired
    private MerchantAccountDao merchantAccountDao;

    @Test
    public void getMerchantAccountInfo() throws Exception {
        String phone = "15022268942";
        String password = "123qwe";
        MerchantAccountInfo getMerchantAccountInfo = merchantAccountDao.getMerchantAccountInfo(phone, password);
        System.out.println("----------");
        System.out.println(getMerchantAccountInfo);
    }

    @Test
    public void getUserByPhone() throws Exception {
        String phone = "15022268942";
        MerchantAccountInfo getUserByPhone = merchantAccountDao.getUserByPhone(phone);
        System.out.println("----------");
        System.out.println(getUserByPhone);
    }

    @Test
    public void getVerifyCode() throws Exception {
        String phone = "15022268942";
        String getVerifyCode = merchantAccountDao.getVerifyCode(phone);
        System.out.println("----------");
        System.out.println(getVerifyCode);
    }

    @Test
    public void getUserByWechatID() throws Exception {
        String wechat_id = "o8PpEv0oX_Hs0jB_4gFVziGhj0N4";
        MerchantAccountInfo getUserByWechatID = merchantAccountDao.getUserByWechatID(wechat_id);
        System.out.println("----------");
        System.out.println(getUserByWechatID);
    }

    @Test
    public void insertUserCountByWechat() throws Exception {
        String wechat_id = "gy2498873793";
        String headimgurl = "987654321";
        boolean insertUserCountByWechat = merchantAccountDao.insertUserCountByWechat(wechat_id,headimgurl);
        System.out.println("----------");
        System.out.println(insertUserCountByWechat);
    }

    @Test
    public void getUserByQQID() throws Exception {
        String qq_id = "DF0F5D5AB5EC73CC26800AB0DAD78177";
        MerchantAccountInfo getUserByQQID = merchantAccountDao.getUserByQQID(qq_id);
        System.out.println("----------");
        System.out.println(getUserByQQID);
    }

    @Test
    public void getRegistration() throws Exception {
        String phone = "15022268942";
        MerchantAccountInfo getRegistration = merchantAccountDao.getRegistration(phone);
        System.out.println("----------");
        System.out.println(getRegistration);
    }

    @Test
    public void getApprovalStatusById() throws Exception {
        int user_id = 1;
        MerchantApprovalStatusInfo getApprovalStatusById = merchantAccountDao.getApprovalStatusById(user_id);
        System.out.println("----------");
        System.out.println(getApprovalStatusById);
    }

    @Test
    public void insertApprovalInfo() throws Exception {
        int user_id = 123;
        String logo_url = "987654321";
        String company_name = "小卞科技有限公司";
        String industry_involved = "服务业";
        String company_address = "天津市和平区";
        String longitude = "123";
        String latitude = "456";
        String head = "文艺你阳哥";
        String job = "ceo";
        String phone = "15022268942";
        String url = "987654321";
        int insertApprovalInfo = merchantAccountDao.insertApprovalInfo(user_id,logo_url,company_name,industry_involved,company_address,longitude,latitude,head,job,phone,url);
        System.out.println("----------");
        System.out.println(insertApprovalInfo);
    }
}