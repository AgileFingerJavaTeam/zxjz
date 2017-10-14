package com.zxjz.service;

import com.zxjz.dto.excution.SecurityPositionExcution;
import com.zxjz.dto.in.SecurityPositionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SecurityPositionServiceTest {
    @Autowired
    private SecurityPositionService securityPositionService;
    @Test
    public void findSearch() throws Exception {
        SecurityPositionDto securityPositionDto = new SecurityPositionDto();
             securityPositionDto.setStatusSearch("1");
             securityPositionDto.setSearch("1");
             securityPositionDto.setPage(1);
             securityPositionDto.setRows(1);
        SecurityPositionExcution securityPositionExcution = securityPositionService.findSearch(securityPositionDto);
        System.out.println("----------------------");
        System.out.println(securityPositionExcution);
    }

}