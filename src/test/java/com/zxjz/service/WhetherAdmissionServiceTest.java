package com.zxjz.service;

import com.zxjz.dto.excution.WhetherAdmissionExcution;
import com.zxjz.dto.in.WhetherAdmissionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class WhetherAdmissionServiceTest {
    @Autowired
    WhetherAdmissionService whetherAdmissionService;

  /*  @Test
    public void whetherAdmission() throws Exception {
        WhetherAdmissionDto whetherAdmissionDto = new WhetherAdmissionDto(77,77,"0");
        WhetherAdmissionExcution whetherAdmissionExcution = whetherAdmissionService.whetherAdmission(whetherAdmissionDto);
        System.out.println("---------");
        System.out.println(whetherAdmissionExcution);
        System.out.println("---------");
    }*/

}