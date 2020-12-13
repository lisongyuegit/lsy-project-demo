package com.lsytest.demo.autocode.demo;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class FieldEntity {
    //表名
    private String tableName;
    //字段名
    private String fieldName;
    //类型
    private String fieldType;
    //注释
    private String fieldDesc;
    //字段大写
    private String fieldAttribute;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldAttribute() {
        return fieldAttribute;
    }

    public void setFieldAttribute(String fieldAttribute) {
        this.fieldAttribute = fieldAttribute;
    }
}
