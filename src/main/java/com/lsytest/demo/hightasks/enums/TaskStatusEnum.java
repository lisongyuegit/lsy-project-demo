package com.lsytest.demo.hightasks.enums;

import com.lsy.base.exception.BusinessException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public enum TaskStatusEnum {
    UNDERWAY("1", "进行中"),
    PLAN("2", "计划中"),
    FINISH("9", "完成");
    private String value;
    private String label;

    TaskStatusEnum(String value, String label) {
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
        List<TaskStatusEnum> list = Arrays.asList(TaskStatusEnum.values());
        for(TaskStatusEnum tempEnum : list){
            if(tempEnum.getValue().equals(value)){
                return tempEnum.getLabel();
            }

        }
        throw new BusinessException(-1,"TaskStatusEnum:参数有误");
    }
}
