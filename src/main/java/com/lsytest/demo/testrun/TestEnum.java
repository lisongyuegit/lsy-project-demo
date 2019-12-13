package com.lsytest.demo.testrun;

import com.lsytest.demo.enums.ColorEnum;

public class TestEnum {
    public static void main(String[] args) {
        ColorEnum aa = ColorEnum.RED;
        aa.setLabel("红色");
        aa.setValue("red");
        System.out.println("11111: "+ aa);
    }
}
