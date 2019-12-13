package com.lsytest.demo.testrun;

import com.lsytest.demo.entity.TestModeEntity;

import java.util.HashMap;
import java.util.Map;

public class TestMapToEntity {
        public static void main(String[] args) {
            String  aaa ;
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",001);
            map.put("name","李松岳");
            map.put("sax","男");
            map.put("age",28);
            map.put("tel","18974849224");
            map.put("create","200a");
            map.put("create_time","2018-08-15");
            map.put("modify",001);
            map.put("modify_time",001);
            map.put("remark","map 转 entity");
            System.out.println("1: " + map);
            TestModeEntity testModeEntity = new TestModeEntity();
            //JSONObject jsonObject = JSONObject.fromObject(map);
            //testModeEntity = JSON.parseObject(map, TestModeEntity.class);
        }

    }

