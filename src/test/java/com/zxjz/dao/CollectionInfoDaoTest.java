package com.zxjz.dao;

import com.zxjz.entity.ListCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CollectionInfoDaoTest {
    @Autowired
    private CollectionInfoDao collectionInfoDao;
    @Test
    public void collectionList() throws Exception {

        List<ListCollection> a = collectionInfoDao.collectionList(2);
        System.out.println("----------");
        System.out.println(a);
    }

}