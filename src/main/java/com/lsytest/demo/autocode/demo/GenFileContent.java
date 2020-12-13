package com.lsytest.demo.autocode.demo;

import com.lsy.base.date.DateHelper;
import com.lsy.base.string.StringHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class GenFileContent {

    public static void startGenFileContent(FileCons fileCons) {
        genApiEntityContent(fileCons);
        genApiServiceContent(fileCons);
        genSerMapperContent(fileCons);
        genSerImplContent(fileCons);
        genSerMapperXmlContent(fileCons);
        genWebControllerContent(fileCons);
        genSerBeanXmlContent(fileCons);
        genSerDubboXmlContent(fileCons);
        genWebDubboXmlContent(fileCons);
    }


    //10.生成bean-xml
    private static void genSerBeanXmlContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("    <!-- " + fileCons.getTableDesc() + " -->\n");
        content.append("    <bean id=\"" + FenUtil.titleLower(fileCons.getApiServiceName()) + "\" class=\"" + fileCons.getSerImplImport() + "\"/>\n");
        content.append("</beans>\n");
        fileCons.setSerBeanXmlContent(content.toString());
        //FenUtil.tihuan("E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\resources\\spring-lsy-project-demo.xml", content.toString(), "</beans>");
    }

    //11.生成ser-dubbo-xml
    private static void genSerDubboXmlContent(FileCons fileCons) {

        StringBuilder content = new StringBuilder();
        content.append("    <!-- " + fileCons.getTableDesc() + " -->\n");
        content.append("       <dubbo:service interface=\"net.edenep.recycle.service.ITempQrCodeService\" ref=\"tempQrCodeService\" registry=\"service_registry\" version=\"1.0.0\"/>\n");
        content.append("</beans>\n");

        fileCons.setSerDubboXmlContent(content.toString());
        //FenUtil.tihuan("E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\resources\\spring-lsy-project-demo.xml", content.toString(), "</beans>");
    }


    //12.生成web-dubbo-xml
    private static void genWebDubboXmlContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("    <!-- " + fileCons.getTableDesc() + " -->\n");
        content.append("    <dubbo:reference interface=\"net.edenep.recycle.service.ITempQrCodeService\" id=\"tempQrCodeService\" check=\"false\" registry=\"recycle_registry\" version=\"1.0.0\"/>\n");
        content.append("</beans>\n");
        fileCons.setWebDubboXmlContent(content.toString());
        //FenUtil.tihuan("E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\resources\\spring-lsy-project-demo.xml", content.toString(), "</beans>");
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

    //5.生成api-entity
    private static void genApiEntityContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("package com.lsytest.demo.autocode;\n");
        content.append("import com.lsy.mybatisplus.annotations.TableField;\n");
        content.append("import com.lsy.mybatisplus.annotations.TableId;\n");
        content.append("import com.lsy.mybatisplus.annotations.TableName;\n");
        content.append("import com.lsy.mybatisplus.enums.IdType;\n");
        content.append("import java.io.Serializable;\n");

        content.append("/**\n");
        content.append(" * " + fileCons.getTableDesc() + "\n");
        content.append(" *\n");
        content.append(" * @author: " + GenConfig.AUTHOR + "\n");
        content.append(" * @company: Eden Technology\n");
        content.append(" * @motto: 代码也可以是一种艺术\n");
        content.append(" * @version: 1.0\n");
        content.append(" * @date: " + DateHelper.formatTime(new Date()) + "\n");
        content.append(" */\n");


        content.append("@TableName(\"" + fileCons.getTableName() + "\")\n");
        content.append("public class " + fileCons.getApiEntityName() + " implements Serializable {\n");
        List<FieldEntity> entityList = fileCons.getFieldEntityList();
        for (FieldEntity fieldEntity : entityList) {

            content.append("    /**\n");
            content.append("    *" + fieldEntity.getFieldDesc() + "\n");
            content.append("    */\n");
            if ("id".equals(fieldEntity.getFieldName())) {
                content.append("    @TableId(value = \"id\", type = IdType.AUTO)\n");
            } else {
                content.append("    @TableField(\"" + fieldEntity.getFieldName() + "\")\n");
            }
            content.append("    private " + fieldEntity.getFieldType() + " " + fieldEntity.getFieldAttribute() + ";" + "\n");
        }

        for (FieldEntity fieldEntity : entityList) {
            content.append("    public " + fieldEntity.getFieldType() + " get" + FenUtil.titleCase(fieldEntity.getFieldAttribute()) + "() {  return " + fieldEntity.getFieldAttribute() + "; }" + "\n");

            content.append("    public void set" + FenUtil.titleCase(fieldEntity.getFieldAttribute()) + "(" + fieldEntity.getFieldType() + " " + fieldEntity.getFieldAttribute() + "){ this." + fieldEntity.getFieldAttribute() + " = " + fieldEntity.getFieldAttribute() + "; }" + "\n");
        }

        content.append("}");
        fileCons.setApiEntityContent(content.toString());
        //String pathStr = GenConfig.PATH + "TestDomeEntity.java";
        //String pathStr = FenUtil.getNowPath() + "TestDomeEntity.java";
        //addFile(content.toString(), pathStr);
    }


    //7.生成ser-mapper
    private static void genSerMapperContent(FileCons fileCons) {

        StringBuilder content = new StringBuilder();
        content.append("package com.lsytest.demo.autocode;\n");

        content.append("import com.lsy.mybatisplus.mapper.BaseMapper;\n");
        content.append("import com.lsy.mybatisplus.plugins.Page;\n");
        content.append("import com.lsytest.demo.autocode." + fileCons.getApiEntityName() + ";\n");
        content.append("import org.apache.ibatis.annotations.Param;\n");

        content.append("import java.util.List;\n");
        content.append("import java.util.Map;\n");

        content.append("/**\n");
        content.append(" * " + fileCons.getTableDesc() + "\n");
        content.append(" *\n");
        content.append(" * @author: " + GenConfig.AUTHOR + "\n");
        content.append(" * @company: Eden Technology\n");
        content.append(" * @motto: 代码也可以是一种艺术\n");
        content.append(" * @version: 1.0\n");
        content.append(" * @date: " + DateHelper.formatTime(new Date()) + "\n");
        content.append(" */\n");
        content.append("public interface " + fileCons.getSerMapperName() + " extends BaseMapper<" + fileCons.getApiEntityName() + "> {\n");
        content.append("    /**\n");
        content.append("     * 新增任务信息\n");
        content.append("     *\n");
        content.append("     * @param queryMap\n");
        content.append("     * @param Page\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    List<Map<String, Object>> queryList(@Param(\"queryMap\") Map<String, Object> queryMap, @Param(\"page\") Page Page);\n");
        content.append("}\n");
        fileCons.setSerMapperContent(content.toString());

        //String pathStr = FenUtil.getNowPath() + fileCons.getSerMapperName() + ".java";
        //addFile(content.toString(), pathStr);
    }

    //6.生成api-service
    private static void genApiServiceContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("package com.lsytest.demo.autocode;\n");
        content.append("import com.lsy.base.result.ResultVo;\n");
        content.append("import com.lsy.mybatisplus.service.IService;\n");
        content.append("import com.lsytest.demo.base.dto.BaseDTO;\n");
        content.append("import java.util.Map;\n");

        content.append("/**\n");
        content.append(" * " + fileCons.getTableDesc() + "\n");
        content.append(" *\n");
        content.append(" * @author: " + GenConfig.AUTHOR + "\n");
        content.append(" * @company: Eden Technology\n");
        content.append(" * @motto: 代码也可以是一种艺术\n");
        content.append(" * @version: 1.0\n");
        content.append(" * @date: " + DateHelper.formatTime(new Date()) + "\n");
        content.append(" */\n");
        content.append("public interface " + fileCons.getApiServiceName() + " extends IService<" + fileCons.getApiEntityName() + "> {\n");
        content.append("  /**\n");
        content.append("     * 查询" + fileCons.getTableDesc() + "\n");
        content.append("    *\n");
        content.append("    * @param queryMap\n");
        content.append("    * @param current\n");
        content.append("    * @param pageSize\n");
        content.append("    * @return\n");
        content.append("    */\n");
        content.append("ResultVo queryList(Map<String, Object> queryMap,  int current,  int pageSize);\n");
        content.append("   /**\n");
        content.append("    * 新增" + fileCons.getTableDesc() + "\n");
        content.append("    *\n");
        content.append("    * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("    * @param baseDTO\n");
        content.append("    * @return\n");
        content.append("    */\n");
        content.append("ResultVo add(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO);\n");
        content.append("   /**\n");
        content.append("    * 编辑" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("    * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("    * @param baseDTO\n");
        content.append("    * @return\n");
        content.append("    */\n");
        content.append("ResultVo edit(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO);\n");
        content.append("   /**\n");
        content.append("    * 删除" + fileCons.getTableDesc() + "\n");
        content.append("    *\n");
        content.append("    * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("    * @param baseDTO\n");
        content.append("    * @return\n");
        content.append("    */\n");
        content.append("ResultVo del(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO);\n");
        content.append("}");
        fileCons.setApiServiceContent(content.toString());
        //String pathStr = FenUtil.getNowPath() + "ITestDomeService.java";
        //addFile(content.toString(), pathStr);

    }

    //8.生成ser-impl
    private static void genSerImplContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("package com.lsytest.demo.autocode;\n");

        content.append("import com.lsy.base.date.DateHelper;\n");
        content.append("import com.lsy.base.result.ResultVo;\n");
        content.append("import com.lsy.mybatisplus.plugins.Page;\n");
        content.append("import com.lsy.mybatisplus.service.impl.ServiceImpl;\n");
        content.append("import com.lsy.mybatisplus.toolkit.CollectionUtils;\n");
        content.append("import com.lsytest.demo.base.dto.BaseDTO;\n");
        content.append("import com.lsytest.demo.base.utils.ComUtil;\n");
        content.append("import com.lsytest.demo.hightasks.entity.TaskEntity;\n");
        content.append("import com.lsytest.demo.hightasks.enums.TaskLevelEnum;\n");
        content.append("import com.lsytest.demo.hightasks.enums.TaskStatusEnum;\n");
        content.append("import com.lsytest.demo.hightasks.mapper.TaskMapper;\n");
        content.append("import com.lsytest.demo.hightasks.service.ITaskService;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");

        content.append("import java.util.Date;\n");
        content.append("import java.util.List;\n");
        content.append("import java.util.Map;\n");

        content.append("/**\n");
        content.append(" * " + fileCons.getTableDesc() + "\n");
        content.append(" *\n");
        content.append(" * @author: " + GenConfig.AUTHOR + "\n");
        content.append(" * @company: Eden Technology\n");
        content.append(" * @motto: 代码也可以是一种艺术\n");
        content.append(" * @version: 1.0\n");
        content.append(" * @date: " + DateHelper.formatTime(new Date()) + "\n");
        content.append(" */\n");
        content.append("public class " + fileCons.getSerImplName() + " extends ServiceImpl<" + fileCons.getSerMapperName() + ", " + fileCons.getApiEntityName() + "> implements " + fileCons.getApiServiceName() + " {\n");
        content.append("    @Autowired\n");
        content.append("    private " + fileCons.getSerMapperName() + " " + FenUtil.titleLower(fileCons.getSerMapperName()) + ";\n");

        content.append("    /**\n");
        content.append("     * 查询" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param queryMap\n");
        content.append("     * @param current\n");
        content.append("     * @param pageSize\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @Override\n");
        content.append("    public ResultVo queryList(Map<String, Object> queryMap, int current,  int pageSize) {\n");
        content.append("        Page<Map<String, Object>> page = new Page<>(current,pageSize);\n");
        content.append("        List<Map<String, Object>> respMapList = " + FenUtil.titleLower(fileCons.getSerMapperName()) + ".queryList(queryMap, page);\n");
        content.append("        page.setRecords(respMapList);\n");
        content.append("        ResultVo resultVo = new ResultVo();\n");
        content.append("        resultVo.setError_no(0);\n");
        content.append("        resultVo.setResult(page);\n");
        content.append("        return resultVo;\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 新增" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @Override\n");
        content.append("    public ResultVo add(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO) {\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setCreateBy(baseDTO.getUserId());\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setCreateDate(DateHelper.formatTime(new Date()));\n");
        content.append("        " + FenUtil.titleLower(fileCons.getSerMapperName()) + ".insert(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ");\n");
        content.append("        ResultVo resultVo = new ResultVo();\n");
        content.append("        resultVo.setError_no(0);\n");
        content.append("        resultVo.setError_info(\"OK\");\n");
        content.append("        return resultVo;\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 编辑" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @Override\n");
        content.append("    public ResultVo edit(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO) {\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setUpdateBy(baseDTO.getUserId());\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setUpdateDate(DateHelper.formatTime(new Date()));\n");
        content.append("        " + FenUtil.titleLower(fileCons.getSerMapperName()) + ".updateById(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ");\n");
        content.append("        ResultVo resultVo = new ResultVo();\n");
        content.append("        resultVo.setError_no(0);\n");
        content.append("        resultVo.setError_info(\"OK\");\n");
        content.append("        return resultVo;\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 删除" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @Override\n");
        content.append("    public ResultVo del(" + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", BaseDTO baseDTO) {\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setUpdateBy(baseDTO.getUserId());\n");
        content.append("        " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".setUpdateDate(DateHelper.formatTime(new Date()));\n");
        content.append("        " + FenUtil.titleLower(fileCons.getSerMapperName()) + ".deleteById(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ");\n");
        content.append("        ResultVo resultVo = new ResultVo();\n");
        content.append("        resultVo.setError_no(0);\n");
        content.append("        resultVo.setError_info(\"OK\");\n");
        content.append("        return resultVo;\n");
        content.append("    }\n");
        content.append(" }\n");

        fileCons.setSerImplContent(content.toString());
        //String pathStr = FenUtil.getNowPath() + fileCons.getSerImplName() + ".java";
        //addFile(content.toString(), pathStr);
    }

    //10.生成bean-xml
    private static void genSerMapperXmlContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();
        content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        content.append("<!DOCTYPE mapper PUBLIC \" -//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        content.append("<mapper namespace=\"" + fileCons.getSerMapperImport() + "\">\n");
        content.append("    <!-- 通用查询映射结果-->\n");
        content.append("    <resultMap id=\"BaseResultMap\" type=\"" + fileCons.getApiEntityImport() + "\">\n");
        List<FieldEntity> entityList = fileCons.getFieldEntityList();
        for (FieldEntity fieldEntity : entityList) {
            if ("id".equals(fieldEntity.getFieldName())) {
                content.append("        <id column=\"" + fieldEntity.getFieldName() + "\" property=\"" + fieldEntity.getFieldAttribute() + "\"/>\n");
            } else {
                content.append("        <result column=\"" + fieldEntity.getFieldName() + "\" property=\"" + fieldEntity.getFieldAttribute() + "\"/>\n");
            }
        }
        content.append("    </resultMap>\n");
        content.append("    <!-- 查询 " + fileCons.getTableDesc() + "-->\n");
        content.append("    <select id=\"queryList\" parameterType=\"java.util.Map\" resultType=\"java.util.Map\">\n");
        content.append("        SELECT\n");


        for (int i = 0; i < entityList.size(); i++) {
            content.append("        t." + entityList.get(i).getFieldName() + " as " + entityList.get(i).getFieldAttribute());
            if (i != entityList.size()-1) {
                content.append(",");
            }
            content.append("\n");
        }
        content.append("        FROM\n");
        content.append("        " + fileCons.getTableName() + " t\n");
        content.append("        <where>\n");
        content.append("            1=1\n");

        for (FieldEntity fieldEntity : entityList) {
            content.append("            <if test=\"null != queryMap." + fieldEntity.getFieldAttribute() + " and '' != queryMap." + fieldEntity.getFieldAttribute() + "\">\n");
            content.append("                and t." + fieldEntity.getFieldName() + " like CONCAT('%',#{queryMap." + fieldEntity.getFieldAttribute() + "},'%')\n");
            content.append("            </if>\n");
        }

        content.append("        </where>\n");
        content.append("        order by t.id desc\n");
        content.append("    </select>\n");
        content.append("</mapper>\n");

        fileCons.setSerMapperXmlContent(content.toString());
        //String pathStr = FenUtil.getNowPath() + fileCons.getSerMapperXmlName() + ".xml";
        //addFile(content.toString(), pathStr);
    }

    //9.生成web-controller
    private static void genWebControllerContent(FileCons fileCons) {
        StringBuilder content = new StringBuilder();

        content.append("package com.lsytest.demo.autocode;\n");

        content.append("import com.lsy.base.result.ResultVo;\n");
        content.append("import com.lsy.mybatisplus.mapper.EntityWrapper;\n");
        content.append("import com.lsytest.demo.base.dto.BaseDTO;\n");
        content.append("import com.lsytest.demo.hightasks.entity.TaskEntity;\n");
        content.append("import com.lsytest.demo.hightasks.service.ITaskService;\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;\n");
        content.append("import org.springframework.web.bind.annotation.*;\n");

        content.append("import java.util.Map;\n");

        content.append("/**\n");
        content.append(" * " + fileCons.getTableDesc() + "\n");
        content.append(" *\n");
        content.append(" * @author: lisongyue@edenep.net\n");
        content.append(" * @company: Eden Technology\n");
        content.append(" * @motto: 代码也可以是一种艺术\n");
        content.append(" * @version: 1.0\n");
        content.append(" * @date: " + DateHelper.formatTime(new Date()) + "\n");
        content.append(" */\n");
        content.append("@RestController\n");
        content.append("@RequestMapping(\"/lsy/demo/task\")\n");
        content.append("public class " + fileCons.getWebControllerName() + " {\n");
        content.append("    @Autowired\n");
        content.append("    private " + fileCons.getApiServiceName() + " " + FenUtil.titleLower(fileCons.getApiServiceName()) + ";\n");

        content.append("    /**\n");
        content.append("     * 查询" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param queryMap\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @GetMapping(value = \"list\")\n");
        content.append("    public ResultVo list(@RequestParam Map queryMap, @ModelAttribute BaseDTO baseDTO) {\n");
        content.append("        int currentInt = baseDTO.getCurrent();\n");
        content.append("        int pageSizeInt = baseDTO.getPageSize();\n");
        content.append("        return " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".queryList(queryMap, currentInt,pageSizeInt);\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 新增" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @PostMapping(value = \"add\")\n");
        content.append("    public ResultVo addTask(@ModelAttribute " + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", @ModelAttribute BaseDTO baseDTO) {\n");
        content.append("        return " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".add(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ", baseDTO);\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 编辑" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @PostMapping(value = \"edit\")\n");
        content.append("    public ResultVo edit(@ModelAttribute " + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", @ModelAttribute BaseDTO baseDTO) {\n");
        content.append("        EntityWrapper<" + fileCons.getApiEntityName() + "> editWrapper = new EntityWrapper<>();\n");
        content.append("        editWrapper.eq(\"id\", " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".getId());\n");
        content.append("        " + fileCons.getApiEntityName() + " resp" + fileCons.getApiEntityName() + " = " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".selectOne(editWrapper);\n");
        content.append("        resp" + fileCons.getApiEntityName() + ".setUpdateDate(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ".getUpdateDate());\n");
        content.append("        return " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".edit(resp" + fileCons.getApiEntityName() + ", baseDTO);\n");
        content.append("    }\n");

        content.append("    /**\n");
        content.append("     * 删除" + fileCons.getTableDesc() + "\n");
        content.append("     *\n");
        content.append("     * @param " + FenUtil.titleLower(fileCons.getApiEntityName()) + "\n");
        content.append("     * @param baseDTO\n");
        content.append("     * @return\n");
        content.append("     */\n");
        content.append("    @PostMapping(value = \"del\")\n");
        content.append("    public ResultVo del(@ModelAttribute " + fileCons.getApiEntityName() + " " + FenUtil.titleLower(fileCons.getApiEntityName()) + ", @ModelAttribute BaseDTO baseDTO) {\n");
        content.append("        EntityWrapper<" + fileCons.getApiEntityName() + "> editWrapper = new EntityWrapper<>();\n");
        content.append("        editWrapper.eq(\"id\", " + FenUtil.titleLower(fileCons.getApiEntityName()) + ".getId());\n");
        content.append("        " + fileCons.getApiEntityName() + " resp" + fileCons.getApiEntityName() + " = " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".selectOne(editWrapper);\n");
        content.append("        resp" + fileCons.getApiEntityName() + ".setUpdateDate(" + FenUtil.titleLower(fileCons.getApiEntityName()) + ".getUpdateDate());\n");
        content.append("        return " + FenUtil.titleLower(fileCons.getApiServiceName()) + ".del(resp" + fileCons.getApiEntityName() + ", baseDTO);\n");
        content.append("    }\n");
        content.append("} 	\n");
        fileCons.setWebControllerContent(content.toString());
        //String pathStr = FenUtil.getNowPath() + fileCons.getApiEntityName() + "Controller.java";
        //addFile(content.toString(), pathStr);
    }
}
