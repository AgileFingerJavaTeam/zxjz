package com.zxjz.dao;

import com.zxjz.entity.ListCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CollectionInfoDaoTest {
    @Autowired
    private CollectionInfoDao collectionInfoDao;

    @Test
    public void deleteCollection() throws Exception {
        int recruiting_id = 6;
        int student_user_id = 6;
        int deleteCollection = collectionInfoDao.deleteCollection(recruiting_id,student_user_id);
        System.out.println("---------");
        System.out.println(deleteCollection);
        System.out.println("---------");
    }

    @Test
    public void CollectionList() throws Exception {
        List<ListCollection> CollectionList = collectionInfoDao.collectionList(1);
        System.out.println("---------");
        System.out.println(CollectionList);
        System.out.println("---------");
    }


    @Test
    public void addCollection() throws Exception {
            int recruiting_id = 6;
            int student_user_id = 6;
            String collection_time = "0000-00-00 00:00:11";
            int collection = collectionInfoDao.addCollection(recruiting_id,student_user_id,collection_time);
            System.out.println("---------");
            System.out.println(collection);
            System.out.println("---------");

    }







}