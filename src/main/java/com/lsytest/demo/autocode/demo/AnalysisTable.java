package com.lsytest.demo.autocode.demo;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import com.lsy.base.string.StringHelper;
import com.lsytest.demo.base.utils.ComUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class AnalysisTable {
    public static FileCons start(String tableStr) {
        FileCons fileCons = new FileCons();
        getTableInfo(fileCons, tableStr);
        className(fileCons);
        path(fileCons);
        impl(fileCons);
        setPackage(fileCons);
        return fileCons;
    }

    //表名/字段
    private static void getTableInfo(FileCons fileCons, String tableStr) {
        List<FieldEntity> entityList = new ArrayList<>();


        String sql = tableStr;
        String dbType = JdbcConstants.MYSQL;

        //格式化输出
        String result = SQLUtils.format(sql, dbType);
        System.out.println(result); // 缺省大写格式
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbType);

        //解析出的独立语句的个数
        System.out.println("size is:" + stmtList.size());
        for (int i = 0; i < stmtList.size(); i++) {

            SQLStatement stmt = stmtList.get(i);

            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);

            Collection<TableStat.Column> list = visitor.getColumns();

            String tempTableName = ((MySqlCreateTableStatement) stmt).getTableSource().toString();
            tempTableName = FenUtil.replace(tempTableName);
            System.out.println("表名为:" + tempTableName);
            fileCons.setTableName(tempTableName);

            String tempTableDesc = ((MySqlCreateTableStatement) stmt).getComment().toString();
            tempTableDesc = FenUtil.replace(tempTableDesc);
            System.out.println("表注释为:" + tempTableDesc);
            fileCons.setTableDesc(tempTableDesc);
            try {
                List<SQLTableElement> sqlTableElementList = ((MySqlCreateTableStatement) stmt).getTableElementList();
                for (SQLTableElement sqlTableElement : sqlTableElementList) {
                    FieldEntity fieldEntity = new FieldEntity();
                    if (StringHelper.isNotEmpty(ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getName()))) {
                        System.out.println("aaaaaa : " + sqlTableElement);
                        String tempFileDesc = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getComment());
                        tempFileDesc = FenUtil.replace(tempFileDesc);
                        System.out.println("注释为:" + tempFileDesc);
                        fieldEntity.setFieldDesc(tempFileDesc);

                        String tempFileType = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getDataType());
                        tempFileType = FenUtil.typeTran(tempFileType);
                        System.out.println("类型为:" + tempFileType);
                        fieldEntity.setFieldType(tempFileType);

                        String tempFileName = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getName());
                        tempFileName = FenUtil.replace(tempFileName);
                        System.out.println("字段为:" + tempFileName);
                        fieldEntity.setFieldName(tempFileName);
                        fieldEntity.setFieldAttribute(FenUtil.getAttribute(fieldEntity.getFieldName()));
                        entityList.add(fieldEntity);
                    }
                }
            } catch (Exception e) {
                System.out.println("运行错误 : ");
                e.printStackTrace();
            }

        }
        fileCons.setFieldEntityList(entityList);
    }

    //类名
    private static void className(FileCons fileCons) {
        String entityName = FenUtil.getEntityName(fileCons.getTableName());
        fileCons.setApiEntityName(entityName + "Entity");
        fileCons.setSerMapperName(entityName + "Mapper");
        fileCons.setSerMapperXmlName(entityName + "Mapper");
        fileCons.setApiServiceName("I" + entityName + "Service");
        fileCons.setSerImplName(entityName + "ServiceImpl");
        fileCons.setWebControllerName(entityName + "Controller");
    }

    //路径
    private static void path(FileCons fileCons) {
        fileCons.setApiEntityPath(FenUtil.getNowPath() + fileCons.getApiEntityName() + ".java");
        fileCons.setApiServicePath(FenUtil.getNowPath() + fileCons.getApiServiceName() + ".java");
        fileCons.setSerMapperPath(FenUtil.getNowPath() + fileCons.getSerMapperName() + ".java");
        fileCons.setSerImplPath(FenUtil.getNowPath() + fileCons.getSerImplName() + ".java");
        fileCons.setSerMapperXmlPath(FenUtil.getNowPath() + fileCons.getSerMapperXmlName() + ".xml");
        fileCons.setWebControllerPath(FenUtil.getNowPath() + fileCons.getWebControllerName() + ".java");
        fileCons.setSerDubboXmlPath(GenConfig.SER_DUBBO_XML_PATH);
        fileCons.setWebDubboXmlPath(GenConfig.WEB_DUBBO_XML_PATH);
        fileCons.setSerBeanXmlPath(GenConfig.SER_BEAN_XML_PATH);
    }

    //impl
    private static void impl(FileCons fileCons) {
        fileCons.setApiEntityImport(fileCons.getApiEntityName());
        fileCons.setApiServiceImport(fileCons.getApiServiceName());
        fileCons.setSerMapperImport(fileCons.getSerMapperName());
        fileCons.setSerImplImport(fileCons.getSerImplName());
        fileCons.setSerMapperXmlImport(fileCons.getSerMapperXmlName());
    }
    //Package
    private static void setPackage(FileCons fileCons) {
        fileCons.setApiEntityPackage("");
        fileCons.setApiServicePackage("");
        fileCons.setSerMapperPackage("");
        fileCons.setSerImplPackage("");
        fileCons.setWebControllerPackage("");
    }
}
