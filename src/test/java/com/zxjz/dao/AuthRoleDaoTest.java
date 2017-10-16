package com.zxjz.dao;

import com.zxjz.entity.AuthRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AuthRoleDaoTest {
    @Autowired
    private AuthRoleDao authRoleDao;
    @Test
    public void findAuthRole() throws Exception {
           int id = 4;
          List<AuthRole> list =  authRoleDao.findAuthRole(id);
        System.out.println("-------------------------");
        System.out.println(list);
    }

}