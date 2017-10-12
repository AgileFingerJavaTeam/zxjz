package com.zxjz.service;

import com.zxjz.dto.excution.SettlementExcution;
import com.zxjz.dto.in.SettlementDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SettlementServiceTest {
    @Autowired
    private SettlementService settlementService;

    @Test
    public void findListSettlement() throws Exception {
        SettlementDto settlementDto = new SettlementDto();
        settlementDto.setPage(1);
        settlementDto.setRows(5);
         SettlementExcution settlementExcution = settlementService.findListSettlement(settlementDto);
        System.out.println("---------");
        System.out.println(settlementExcution);
        System.out.println("---------");

    }

    @Test
    public void findSearch() throws Exception {
        SettlementDto settlementDto = new SettlementDto();
        settlementDto.setPage(1);
        settlementDto.setRows(5);
        settlementDto.setSearch("1");
        SettlementExcution settlementExcution = settlementService.findSearch(settlementDto);
        System.out.println("---------");
        System.out.println(settlementExcution);
        System.out.println("---------");
    }

    @Test
    public void getSettlementData() throws Exception {

    }

    @Test
    public void findMaxNumber() throws Exception {

    }

    @Test
    public void saveFunction() throws Exception {

    }

    @Test
    public void findMerchantsName() throws Exception {

    }

}