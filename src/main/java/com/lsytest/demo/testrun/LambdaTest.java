package com.lsytest.demo.testrun;

import com.alibaba.fastjson.JSONObject;
import com.lsytest.demo.entity.ImportEntity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    public static void main(String[] args) {
        List<ImportEntity> testEntity = build();
        System.out.println("11111   " + JSONObject.toJSON(testEntity));
        testEntity.stream().filter(item -> item.getName().equals("姓名")).forEach(System.out::println);
        boolean b1 = testEntity.stream().allMatch((e) -> e.getName().equals("姓名"));
        System.out.println(b1);

        List<String> aaa = testEntity.stream().map(ImportEntity :: getName).collect(Collectors.toList());
        System.out.println("33333   " + JSONObject.toJSON(aaa));

         long bbb = testEntity.stream().filter(num -> num.getName().equals("姓名")).count();
        System.out.println("44444   " + JSONObject.toJSON(bbb));

        List<ImportEntity> aaaaa = testEntity.stream().filter(list -> list.getName().equals("姓名1")).collect(Collectors.toList());
        if(null == aaaaa){
            //这里添加报错信息
        }else{
            //这里开始赋值
        }
        System.out.println("55555   " + JSONObject.toJSON(aaaaa));
    }
    public static List<ImportEntity> build(){
        List<ImportEntity> improtList = new ArrayList<>();
        ImportEntity improt = new ImportEntity();
        improt.setName("姓名");
        improt.setValue("name");
        improtList.add(improt);

        ImportEntity improt2 = new ImportEntity();
        improt2.setName("性别");
        improt2.setValue("sax");
        improtList.add(improt2);

        ImportEntity improt3 = new ImportEntity();
        improt3.setName("身高");
        improt3.setValue("height");
        improtList.add(improt3);

        ImportEntity improt4 = new ImportEntity();
        improt4.setName("体重");
        improt4.setValue("weight");
        improtList.add(improt4);

        ImportEntity improt5 = new ImportEntity();
        improt5.setName("电话");
        improt5.setValue("tel");
        improtList.add(improt5);

        return improtList;
    }
}
