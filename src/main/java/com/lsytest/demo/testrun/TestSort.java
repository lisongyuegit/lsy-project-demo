package com.lsytest.demo.testrun;

import com.lsytest.demo.entity.TestModeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSort {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private void testSort(){
        List<TestModeEntity> listEntity = new ArrayList<TestModeEntity>();
        TestModeEntity testEntiy = new TestModeEntity();
        testEntiy.setId(1);
        testEntiy.setAge("27");
        testEntiy.setCreate("2000");
        testEntiy.setName("李松岳");
        testEntiy.setSax("男");
        listEntity.add(testEntiy);
        TestModeEntity testEntiy2 = new TestModeEntity();
        testEntiy2.setId(2);
        testEntiy2.setAge("26");
        testEntiy2.setCreate("2000");
        testEntiy2.setName("李松岳");
        testEntiy2.setSax("男");
        listEntity.add(testEntiy2);
        TestModeEntity testEntiy3 = new TestModeEntity();
        testEntiy3.setId(3);
        testEntiy3.setAge("29");
        testEntiy3.setCreate("2000");
        testEntiy3.setName("李松岳");
        testEntiy3.setSax("男");
        listEntity.add(testEntiy3);
        for(int i = 0 ; i < listEntity.size() ; i++){
            logger.info("排序前: "+listEntity.get(i).getAge());
        }
        //排序操作
        Collections.sort(listEntity,new Comparator<TestModeEntity>() {
            @Override
            public int compare(TestModeEntity o1, TestModeEntity o2) {
                return o2.getAge().compareTo(o1.getAge());
            }
        });
        for(int i = 0 ; i < listEntity.size() ; i++){
            logger.info("排序后: "+listEntity.get(i).getAge());
        }
    }
    private void testSort2(){
        List<TestModeEntity> listEntity = new ArrayList<TestModeEntity>();
        TestModeEntity testEntiy = new TestModeEntity();
        testEntiy.setId(1);
        testEntiy.setAge("27");
        testEntiy.setCreate("2000");
        testEntiy.setName("李松岳");
        testEntiy.setSax("男");
        listEntity.add(testEntiy);
        TestModeEntity testEntiy2 = new TestModeEntity();
        testEntiy2.setId(2);
        testEntiy2.setAge("26");
        testEntiy2.setCreate("2000");
        testEntiy2.setName("李松岳");
        testEntiy2.setSax("男");
        listEntity.add(testEntiy2);
        TestModeEntity testEntiy3 = new TestModeEntity();
        testEntiy3.setId(3);
        testEntiy3.setAge("29");
        testEntiy3.setCreate("2000");
        testEntiy3.setName("李松岳");
        testEntiy3.setSax("男");
        listEntity.add(testEntiy3);
        for(int i = 0 ; i < listEntity.size() ; i++){
            logger.info("排序前: "+listEntity.get(i).getAge());
        }
        //排序操作
        listEntity.stream().sorted().forEach(System.out::println);

        for(int i = 0 ; i < listEntity.size() ; i++){
            logger.info("排序后: "+listEntity.get(i).getAge());
        }
    }
}
