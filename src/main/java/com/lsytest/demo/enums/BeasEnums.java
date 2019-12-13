package com.lsytest.demo.enums;

public enum BeasEnums {
    NAME("name", "1111"),
    VALUE("value", "2222");
    private String value;
    private String label;
    BeasEnums(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public String getValue() {
        return value;
    }
}
