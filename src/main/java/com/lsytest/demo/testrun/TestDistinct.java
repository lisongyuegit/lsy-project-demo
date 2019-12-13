package com.lsytest.demo.testrun;

import com.lsytest.demo.utlis.DataDistinctCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDistinct {
    public static void main(String[] args) {
        List<String> reqList = new ArrayList() {
            {
                add("111");
                add("444");
                add("222");
                add("222");
                add("555");
                add("555");
                add("333");
                add("333");
            }
        };
        Map<String,Object> result = DataDistinctCheck.distinctChek(reqList);
        System.out.println("返回结果为:" + result);
        String repeatData = result.get("repeatData").toString();
        System.out.println("repeatData:" + repeatData);
        boolean  isRepeat = Boolean.parseBoolean(result.get("isRepeat").toString());
        System.out.println("isRepeat:" + isRepeat);
    }
}
