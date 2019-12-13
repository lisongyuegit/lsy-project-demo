//package com.lsytest.demo.testrun;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.lsytest.demo.entity.TestEntity;
//import com.lsytest.demo.entity.ImportEntity;
//import com.lsytest.demo.entity.TestEntity;
//import com.lsytest.demo.utlis.excel.EJtool;
//import com.lsytest.demo.utlis.excel.JsonTool;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ExcelImprot {
//    private JsonTool jsonTool = new JsonTool();
//
//    public static void main(String[] args) {
//        String reslut = new EJtool().ExcelToJson("H:\\LiSongYue\\TempTest\\ImportTest4.xlsx",null);
//        //String reslut = new EJtool().ExcelToJson("E:\\LiSongYue\\TempTest\\ImportTest3.xlsx", null);
//        //String reslut = new EJtool().ExcelToJson("../files/ImportTest3.xlsx", null);
//        System.out.println("读取的数据为: " + reslut);
//        List<ImportEntity> importList = build();
//        JSONArray arrayData = JSONArray.parseArray(reslut);
//        System.out.println("需要处理数据天数为: " + arrayData.size());
//
//        for (int x = 0; x < arrayData.size(); x++) {
//            Map<String, Object> map = (Map<String, Object>) arrayData.get(x);
//            Map<String, Object> tempMap = new HashMap<>();
//
//            for (int i = 0; i < importList.size(); i++) {
//                tempMap.put(importList.get(i).getValue(), map.get(importList.get(i).getName()));
//                Object str = map.get(importList.get(i).getName());
//                System.out.println("日志输出:" + importList.get(i).getName() + ": " + str.toString());
//            }
//            String tempStr = JSONObject.toJSON(tempMap).toString();
//            TestEntity newEntityTest = JSON.parseObject(tempStr, TestEntity.class);
//            System.out.println("tempMap: " + tempMap);
//            System.out.println(x+1 + " : newEntityTest:" + JSONObject.toJSON(newEntityTest));
//        }
//    }
//
//    public static List<ImportEntity> build(){
//        List<ImportEntity> improtList = new ArrayList<>();
//        ImportEntity improt = new ImportEntity();
//        improt.setName("姓名");
//        improt.setValue("name");
//        improtList.add(improt);
//
//        ImportEntity improt2 = new ImportEntity();
//        improt2.setName("性别");
//        improt2.setValue("sax");
//        improtList.add(improt2);
//
//        ImportEntity improt3 = new ImportEntity();
//        improt3.setName("身高");
//        improt3.setValue("height");
//        improtList.add(improt3);
//
//        ImportEntity improt4 = new ImportEntity();
//        improt4.setName("体重");
//        improt4.setValue("weight");
//        improtList.add(improt4);
//
//        ImportEntity improt5 = new ImportEntity();
//        improt5.setName("电话");
//        improt5.setValue("tel");
//        improtList.add(improt5);
//
//        return improtList;
//    }
//}
