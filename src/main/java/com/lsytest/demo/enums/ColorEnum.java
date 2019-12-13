package com.lsytest.demo.enums;

public enum ColorEnum {
    GREEN, YELLOW, RED;
    private String value;
    private String label;
    public void setLabel(String label) {
        this.label = label;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
