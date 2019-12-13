package com.lsytest.demo.testrun;

import com.lsytest.demo.entity.TestEntity;

import java.lang.reflect.Field;

/**
 * 循环出Entity的属性值
 * 继承的属性值是循环不出来的
 */
public class GetEntityProperty {

    public static void main(String[] args) throws Exception {
        TestEntity entityTest = new TestEntity();
        entityTest.setName("李松岳");
        entityTest.setHeight(174);
        entityTest.setWeight(72);
        entityTest.setSax("28");
        entityTest.setTel("18974849224");
        reflect(entityTest);
    }

    public static void reflect(TestEntity e) throws Exception {
        Class cls = e.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
        }
    }
    }
