package com.zxjz.dao;

import com.zxjz.entity.SystemParameter;
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
public class SystemParameterDaoTest {



    @Autowired
    private SystemParameterDao systemParameterDao;
    @Test
    public void findSystemPatameter() throws Exception {
        List<SystemParameter> systemParametersList = systemParameterDao.findSystemPatameter(1,20,null);
        System.out.println("---------------");
        System.out.println(systemParametersList);
        System.out.println("----------------");
    }
    //--测试通过Id查询一条系统参数
    @Test
    public void findSystemParameterInfoById() throws Exception {
        SystemParameter systemParameter = systemParameterDao.findSystemParameterInfoById(1);
        System.out.println("-------------");
        System.out.println(systemParameter);
        System.out.println("-------------");
    }
    //测试新增一条系统参数
    @Test
    public void AddSystemParameter() throws Exception {
        int isAdd = systemParameterDao.addSystemParameter("6","ceshi","jiushiceshi","thanks");
        System.out.println("-------------");
        System.out.println(isAdd);
        System.out.println("-------------");
    }
    //测试编辑一条系统参数
    @Test
    public void updateSystemParameter() throws Exception {
        int isUpdate = systemParameterDao.updateSystemParameter(6,"6","消愁","毛不易","maojuxing");
        System.out.println("-----------------");
        System.out.println(isUpdate);
        System.out.println("-----------------");
    }
    @Test
    public void delSystemParameter() throws Exception {
        int isDel = systemParameterDao.delSystemParameter(6);
        System.out.println("-----------------");
        System.out.println(isDel);
        System.out.println("------------------");
    }

}