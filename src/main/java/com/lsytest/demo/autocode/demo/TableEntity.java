package com.lsytest.demo.autocode.demo;

import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class TableEntity {
    /**
     *表名
     */
    private String tableName;
    /**
     * 表描述
     */
    private String tableDesc;
    /**
     * 字段属性集合
     */
    private List<FieldEntity> fieldEntityList;
    /**
     * apiEntity类名
     */
    private String apiEntityName;
    /**
     * apiService类名
     */
    private String apiServiceName;
    /**
     * serMapper类名
     */
    private String serMapperName;
    /**
     * serMapperXml类名
     */
    private String serMapperXmlName;
    /**
     * serImpl类名
     */
    private String serImplName;
    /**
     * private String webController类名
     */
    private String webControllerName;
    /**
     * apiEntity文件路径
     */
    private String apiEntityPath;
    /**
     * apiService文件路径
     */
    private String apiServicePath;
    /**
     * serMapper文件路径
     */
    private String serMapperPath;
    /**
     * serImpl文件路径
     */
    private String serImplPath;
    /**
     * serMapperXml文件路径
     */
    private String serMapperXmlPath;
    /**
     * serBeanXml文件路径
     */
    private String serBeanXmlPath;
    /**
     * serDubboXml文件路径
     */
    private String serDubboXmlPath;
    /**
     * webController文件路径
     */
    private String webControllerPath;
    /**
     * webDubboXml文件路径
     */
    private String webDubboXmlPath;
    /**
     * apiEntit内容
     */
    private String apiEntityContent;
    /**
     * apiService内容
     */
    private String apiServiceContent;
    /**
     * serMapper内容
     */
    private String serMapperContent;
    /**
     * serImpl内容
     */
    private String serImplContent;
    /**
     * MapperXml内容
     */
    private String serMapperXmlContent;
    /**
     * serBeanXml内容
     */
    private String serBeanXmlContent;
    /**
     * serDubboXml内容
     */
    private String serDubboXmlContent;
    /**
     * webController内容
     */
    private String webControllerContent;
    /**
     * webDubboXml内容
     */
    private String webDubboXmlContent;
    /**
     * api端Entity导入路径
     */
    private String apiEntityImport;
    /**
     * api端Service导入路径
     */
    private String apiServiceImport;
    /**
     * service端Mapper导入路径
     */
    private String serMapperImport;
    /**
     * service端Impl导入路径
     */
    private String serImplImport;
    /**
     * service端
     */
    private String serMapperXmlImport;
    /**
     * api端Entity包路径
     */
    private String apiEntityPackage;
    /**
     * api端Service包路径
     */
    private String apiServicePackage;
    /**
     * service端Mapper包路径
     */
    private String serMapperPackage;
    /**
     * service端Impl包路径
     */
    private String serImplPackage;
    /**
     * web端Controller包路径
     */
    private String webControllerPackage;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldEntity> getFieldEntityList() {
        return fieldEntityList;
    }

    public void setFieldEntityList(List<FieldEntity> fieldEntityList) {
        this.fieldEntityList = fieldEntityList;
    }

    public String getApiEntityName() {
        return apiEntityName;
    }

    public void setApiEntityName(String apiEntityName) {
        this.apiEntityName = apiEntityName;
    }

    public String getApiServiceName() {
        return apiServiceName;
    }

    public void setApiServiceName(String apiServiceName) {
        this.apiServiceName = apiServiceName;
    }

    public String getSerMapperName() {
        return serMapperName;
    }

    public void setSerMapperName(String serMapperName) {
        this.serMapperName = serMapperName;
    }

    public String getSerMapperXmlName() {
        return serMapperXmlName;
    }

    public void setSerMapperXmlName(String serMapperXmlName) {
        this.serMapperXmlName = serMapperXmlName;
    }

    public String getSerImplName() {
        return serImplName;
    }

    public void setSerImplName(String serImplName) {
        this.serImplName = serImplName;
    }

    public String getWebControllerName() {
        return webControllerName;
    }

    public void setWebControllerName(String webControllerName) {
        this.webControllerName = webControllerName;
    }

    public String getApiEntityPath() {
        return apiEntityPath;
    }

    public void setApiEntityPath(String apiEntityPath) {
        this.apiEntityPath = apiEntityPath;
    }

    public String getApiServicePath() {
        return apiServicePath;
    }

    public void setApiServicePath(String apiServicePath) {
        this.apiServicePath = apiServicePath;
    }

    public String getSerMapperPath() {
        return serMapperPath;
    }

    public void setSerMapperPath(String serMapperPath) {
        this.serMapperPath = serMapperPath;
    }

    public String getSerImplPath() {
        return serImplPath;
    }

    public void setSerImplPath(String serImplPath) {
        this.serImplPath = serImplPath;
    }

    public String getSerMapperXmlPath() {
        return serMapperXmlPath;
    }

    public void setSerMapperXmlPath(String serMapperXmlPath) {
        this.serMapperXmlPath = serMapperXmlPath;
    }

    public String getSerBeanXmlPath() {
        return serBeanXmlPath;
    }

    public void setSerBeanXmlPath(String serBeanXmlPath) {
        this.serBeanXmlPath = serBeanXmlPath;
    }

    public String getSerDubboXmlPath() {
        return serDubboXmlPath;
    }

    public void setSerDubboXmlPath(String serDubboXmlPath) {
        this.serDubboXmlPath = serDubboXmlPath;
    }

    public String getWebControllerPath() {
        return webControllerPath;
    }

    public void setWebControllerPath(String webControllerPath) {
        this.webControllerPath = webControllerPath;
    }

    public String getWebDubboXmlPath() {
        return webDubboXmlPath;
    }

    public void setWebDubboXmlPath(String webDubboXmlPath) {
        this.webDubboXmlPath = webDubboXmlPath;
    }

    public String getApiEntityContent() {
        return apiEntityContent;
    }

    public void setApiEntityContent(String apiEntityContent) {
        this.apiEntityContent = apiEntityContent;
    }

    public String getApiServiceContent() {
        return apiServiceContent;
    }

    public void setApiServiceContent(String apiServiceContent) {
        this.apiServiceContent = apiServiceContent;
    }

    public String getSerMapperContent() {
        return serMapperContent;
    }

    public void setSerMapperContent(String serMapperContent) {
        this.serMapperContent = serMapperContent;
    }

    public String getSerImplContent() {
        return serImplContent;
    }

    public void setSerImplContent(String serImplContent) {
        this.serImplContent = serImplContent;
    }

    public String getSerMapperXmlContent() {
        return serMapperXmlContent;
    }

    public void setSerMapperXmlContent(String serMapperXmlContent) {
        this.serMapperXmlContent = serMapperXmlContent;
    }

    public String getSerBeanXmlContent() {
        return serBeanXmlContent;
    }

    public void setSerBeanXmlContent(String serBeanXmlContent) {
        this.serBeanXmlContent = serBeanXmlContent;
    }

    public String getSerDubboXmlContent() {
        return serDubboXmlContent;
    }

    public void setSerDubboXmlContent(String serDubboXmlContent) {
        this.serDubboXmlContent = serDubboXmlContent;
    }

    public String getWebControllerContent() {
        return webControllerContent;
    }

    public void setWebControllerContent(String webControllerContent) {
        this.webControllerContent = webControllerContent;
    }

    public String getWebDubboXmlContent() {
        return webDubboXmlContent;
    }

    public void setWebDubboXmlContent(String webDubboXmlContent) {
        this.webDubboXmlContent = webDubboXmlContent;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public String getApiEntityImport() {
        return apiEntityImport;
    }

    public void setApiEntityImport(String apiEntityImport) {
        this.apiEntityImport = apiEntityImport;
    }

    public String getApiServiceImport() {
        return apiServiceImport;
    }

    public void setApiServiceImport(String apiServiceImport) {
        this.apiServiceImport = apiServiceImport;
    }

    public String getSerMapperImport() {
        return serMapperImport;
    }

    public void setSerMapperImport(String serMapperImport) {
        this.serMapperImport = serMapperImport;
    }

    public String getSerImplImport() {
        return serImplImport;
    }

    public void setSerImplImport(String serImplImport) {
        this.serImplImport = serImplImport;
    }

    public String getSerMapperXmlImport() {
        return serMapperXmlImport;
    }

    public void setSerMapperXmlImport(String serMapperXmlImport) {
        this.serMapperXmlImport = serMapperXmlImport;
    }

    public String getApiEntityPackage() {
        return apiEntityPackage;
    }

    public void setApiEntityPackage(String apiEntityPackage) {
        this.apiEntityPackage = apiEntityPackage;
    }

    public String getApiServicePackage() {
        return apiServicePackage;
    }

    public void setApiServicePackage(String apiServicePackage) {
        this.apiServicePackage = apiServicePackage;
    }

    public String getSerMapperPackage() {
        return serMapperPackage;
    }

    public void setSerMapperPackage(String serMapperPackage) {
        this.serMapperPackage = serMapperPackage;
    }

    public String getSerImplPackage() {
        return serImplPackage;
    }

    public void setSerImplPackage(String serImplPackage) {
        this.serImplPackage = serImplPackage;
    }

    public String getWebControllerPackage() {
        return webControllerPackage;
    }

    public void setWebControllerPackage(String webControllerPackage) {
        this.webControllerPackage = webControllerPackage;
    }
}
