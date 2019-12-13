package com.lsytest.demo.utlis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataDistinctCheck {
    public static Map<String,Object> distinctChek(List<String> dataList){
        Map<String,Object> resultMap = new HashMap<>();
        long count = dataList.stream().distinct().count();
        boolean isRepeat = count < dataList.size();
        String removeDuplication = dataList.stream().distinct().collect(Collectors.joining(","));
        List<String> repeatData = dataList.stream().collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // Set<Entry>转换为Stream<Entry>
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
        System.out.println("重复条数:" + count);
        System.out.println("是否重复:" + isRepeat);
        System.out.println("重复数据为:" + repeatData);
        resultMap.put("重复条数",count + "");
        resultMap.put("isRepeat",isRepeat + "");
        resultMap.put("repeatData",repeatData + "");
        resultMap.put("removeDuplication",removeDuplication + "");
        return resultMap;
    }
}
