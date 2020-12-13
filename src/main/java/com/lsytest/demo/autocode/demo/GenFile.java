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

    public static void startGenFile(FileCons fileCons) {
        genApiEntity(fileCons);
        genApiService(fileCons);
        genSerMapper(fileCons);
        genSerImpl(fileCons);
        genSerMapperXml(fileCons);
        genWebController(fileCons);
        genSerBeanXml(fileCons);
        genSerDubboXml(fileCons);
        genWebDubboXml(fileCons);
    }

    //10.生成bean-xml
    private static void genSerBeanXml(FileCons fileCons) {
        String content = fileCons.getSerBeanXmlContent();
        String pathStr = fileCons.getSerBeanXmlPath();
        FenUtil.tihuan(pathStr, content, "</beans>");
    }

    //11.生成ser-dubbo-xml
    private static void genSerDubboXml(FileCons fileCons) {
        String content = fileCons.getSerDubboXmlContent();
        String pathStr = fileCons.getSerDubboXmlPath();
        FenUtil.tihuan(pathStr, content, "</beans>");
    }

    //12.生成web-dubbo-xml
    private static void genWebDubboXml(FileCons fileCons) {
        String content = fileCons.getWebDubboXmlContent();
        String pathStr = fileCons.getWebDubboXmlPath();
        FenUtil.tihuan(pathStr, content, "</beans>");
    }

    //5.生成api-entity
    private static void genApiEntity(FileCons fileCons) {
        String content = fileCons.getApiEntityContent();
        String pathStr = fileCons.getApiEntityPath();
        addFile(content, pathStr);
    }

    //7.生成ser-mapper
    private static void genSerMapper(FileCons fileCons) {
        String content = fileCons.getSerMapperContent();
        String pathStr = fileCons.getSerMapperPath();
        addFile(content, pathStr);
    }

    //6.生成api-service
    private static void genApiService(FileCons fileCons) {
        String content = fileCons.getApiServiceContent();
        String pathStr = fileCons.getApiServicePath();
        addFile(content, pathStr);
    }

    //8.生成ser-impl
    private static void genSerImpl(FileCons fileCons) {
        String content = fileCons.getSerImplContent();
        String pathStr = fileCons.getSerImplPath();
        addFile(content, pathStr);
    }

    //10.生成bean-xml
    private static void genSerMapperXml(FileCons fileCons) {
        String content = fileCons.getSerMapperXmlContent();
        String pathStr = fileCons.getSerMapperXmlPath();
        addFile(content, pathStr);
    }

    //9.生成web-controller
    private static void genWebController(FileCons fileCons) {
        String content = fileCons.getWebControllerContent();
        String pathStr = fileCons.getWebControllerPath();
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
