package com.zxjz.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class CollectionServiceTest {
    @Autowired
    private CollectionService collectionService;
   /* @Test
    public void deleteConllection() throws Exception {
        CollectionDto collectionDto = new CollectionDto();
        collectionDto.setRecruiting_id(7);
        collectionDto.setStudent_user_id(7);
        CollectionExcution collectionExcution = collectionService.deleteConllection(collectionDto);
        System.out.println("---------");
        System.out.println(collectionExcution);
        System.out.println("---------");
    }


    @Test
    public void addConllection() throws Exception {
        CollectionDto collectionDto = new CollectionDto();
        collectionDto.setRecruiting_id(7);
        collectionDto.setStudent_user_id(7);
        collectionDto.setCollection_time("2017-09-27 17:47:09");
        CollectionExcution collectionExcution = collectionService.addConllection(collectionDto);
        System.out.println("---------");
        System.out.println(collectionExcution);
        System.out.println("---------");
    }


    @Test
    public void collectionList() throws Exception {
        CollectionListDto collectionListDto = new CollectionListDto(1);
        CollectionExcution collectionExcution = collectionService.collectionList(collectionListDto);
        System.out.println("---------");
        System.out.println(collectionExcution);
        System.out.println("---------");
    }*/

}