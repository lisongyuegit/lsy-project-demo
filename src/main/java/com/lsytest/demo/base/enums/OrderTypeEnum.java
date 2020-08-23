package com.lsytest.demo.base.enums;

import com.lsytest.demo.hightasks.enums.TaskStatusEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public enum OrderTypeEnum {
    UNDERWAY("1", "进行中"),
    PLAN("2", "计划中"),
    FINISH("9", "完成");
    private String value;
    private String label;

    OrderTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel(){
        return label;
    }
    public String getLabel(String value){
        List<OrderTypeEnum> list = Arrays.asList(OrderTypeEnum.values());
        for(OrderTypeEnum tempEnum : list){
            if(tempEnum.value.equals(value)){
                return tempEnum.getLabel();
            }

        }
        return label;
    }
}
