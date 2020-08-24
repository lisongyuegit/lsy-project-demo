package com.lsytest.demo.hightasks.enums;

import com.lsy.base.exception.BusinessException;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public enum TaskLevelEnum {
    ONE("1", "很重要-很紧急"),
    TWO("2", "重要-不紧急"),
    THREE("3", "不重要-紧急"),
    FOUR("4", "不重要-不紧急");
    private String value;
    private String label;
    TaskLevelEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public String getValue() {
        return value;
    }
    public String getLabel(){
        return label;
    }
    public static String getLabel(String value){
        List<TaskLevelEnum> list = Arrays.asList(TaskLevelEnum.values());
        for(TaskLevelEnum tempEnum : list){
            if(tempEnum.getValue().equals(value)){
                return tempEnum.getLabel();
            }

        }
        throw new BusinessException(-1,"TaskLevelEnum:参数有误");
    }
    public static String checkValue(String value){
        List<TaskLevelEnum> list = Arrays.asList(TaskLevelEnum.values());
        for(TaskLevelEnum tempEnum : list){
            if(tempEnum.getValue().equals(value)){
                return tempEnum.getLabel();
            }

        }
        throw new BusinessException(-1,"TaskLevelEnum:参数有误");
    }
}
