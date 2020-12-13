package com.lsytest.demo.autocode.demo;

import com.lsy.base.string.StringHelper;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class GenFile {

    public static void startGenFile(TableEntity tableEntity) {
        genApiEntity(tableEntity);
        genApiService(tableEntity);
        genSerMapper(tableEntity);
        genSerImpl(tableEntity);
        genSerMapperXml(tableEntity);
        genWebController(tableEntity);
        genSerBeanXml(tableEntity);
        genSerDubboXml(tableEntity);
        genWebDubboXml(tableEntity);
    }

    //10.生成bean-xml
    private static void genSerBeanXml(TableEntity tableEntity) {
        String content = tableEntity.getSerBeanXmlContent();
        String pathStr = tableEntity.getSerBeanXmlPath();
        GenUtil.tihuan(pathStr, content, "</beans>");
    }

    //11.生成ser-dubbo-xml
    private static void genSerDubboXml(TableEntity tableEntity) {
        String content = tableEntity.getSerDubboXmlContent();
        String pathStr = tableEntity.getSerDubboXmlPath();
        GenUtil.tihuan(pathStr, content, "</beans>");
    }

    //12.生成web-dubbo-xml
    private static void genWebDubboXml(TableEntity tableEntity) {
        String content = tableEntity.getWebDubboXmlContent();
        String pathStr = tableEntity.getWebDubboXmlPath();
        GenUtil.tihuan(pathStr, content, "</beans>");
    }

    //5.生成api-entity
    private static void genApiEntity(TableEntity tableEntity) {
        String content = tableEntity.getApiEntityContent();
        String pathStr = tableEntity.getApiEntityPath();
        addFile(content, pathStr);
    }

    //7.生成ser-mapper
    private static void genSerMapper(TableEntity tableEntity) {
        String content = tableEntity.getSerMapperContent();
        String pathStr = tableEntity.getSerMapperPath();
        addFile(content, pathStr);
    }

    //6.生成api-service
    private static void genApiService(TableEntity tableEntity) {
        String content = tableEntity.getApiServiceContent();
        String pathStr = tableEntity.getApiServicePath();
        addFile(content, pathStr);
    }

    //8.生成ser-impl
    private static void genSerImpl(TableEntity tableEntity) {
        String content = tableEntity.getSerImplContent();
        String pathStr = tableEntity.getSerImplPath();
        addFile(content, pathStr);
    }

    //10.生成bean-xml
    private static void genSerMapperXml(TableEntity tableEntity) {
        String content = tableEntity.getSerMapperXmlContent();
        String pathStr = tableEntity.getSerMapperXmlPath();
        addFile(content, pathStr);
    }

    //9.生成web-controller
    private static void genWebController(TableEntity tableEntity) {
        String content = tableEntity.getWebControllerContent();
        String pathStr = tableEntity.getWebControllerPath();
        addFile(content, pathStr);
    }

    private static void addFile(String content, String fileUrl) {

        if (StringHelper.isBlank(content)) {
            content = "hello world!";
        }
        FileWriter writer;
        try {
            writer = new FileWriter(fileUrl);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
