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
    public static TableEntity start(String tableStr) {
        TableEntity tableEntity = new TableEntity();
        getTableInfo(tableEntity, tableStr);
        className(tableEntity);
        path(tableEntity);
        impl(tableEntity);
        setPackage(tableEntity);
        return tableEntity;
    }

    //表名/字段
    private static void getTableInfo(TableEntity tableEntity, String tableStr) {
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
            tempTableName = GenUtil.replace(tempTableName);
            System.out.println("表名为:" + tempTableName);
            tableEntity.setTableName(tempTableName);

            String tempTableDesc = ((MySqlCreateTableStatement) stmt).getComment().toString();
            tempTableDesc = GenUtil.replace(tempTableDesc);
            System.out.println("表注释为:" + tempTableDesc);
            tableEntity.setTableDesc(tempTableDesc);
            try {
                List<SQLTableElement> sqlTableElementList = ((MySqlCreateTableStatement) stmt).getTableElementList();
                for (SQLTableElement sqlTableElement : sqlTableElementList) {
                    FieldEntity fieldEntity = new FieldEntity();
                    if (StringHelper.isNotEmpty(ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getName()))) {
                        System.out.println("aaaaaa : " + sqlTableElement);
                        String tempFileDesc = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getComment());
                        tempFileDesc = GenUtil.replace(tempFileDesc);
                        System.out.println("注释为:" + tempFileDesc);
                        fieldEntity.setFieldDesc(tempFileDesc);

                        String tempFileType = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getDataType());
                        tempFileType = GenUtil.typeTran(tempFileType);
                        System.out.println("类型为:" + tempFileType);
                        fieldEntity.setFieldType(tempFileType);

                        String tempFileName = ComUtil.objToStr(((SQLColumnDefinition) sqlTableElement).getName());
                        tempFileName = GenUtil.replace(tempFileName);
                        System.out.println("字段为:" + tempFileName);
                        fieldEntity.setFieldName(tempFileName);
                        fieldEntity.setFieldAttribute(GenUtil.getAttribute(fieldEntity.getFieldName()));
                        entityList.add(fieldEntity);
                    }
                }
            } catch (Exception e) {
                System.out.println("运行错误 : ");
                e.printStackTrace();
            }

        }
        tableEntity.setFieldEntityList(entityList);
    }

    //类名
    private static void className(TableEntity tableEntity) {
        String entityName = GenUtil.getEntityName(tableEntity.getTableName());
        tableEntity.setApiEntityName(entityName + "Entity");
        tableEntity.setSerMapperName(entityName + "Mapper");
        tableEntity.setSerMapperXmlName(entityName + "Mapper");
        tableEntity.setApiServiceName("I" + entityName + "Service");
        tableEntity.setSerImplName(entityName + "ServiceImpl");
        tableEntity.setWebControllerName(entityName + "Controller");
    }

    //路径
    private static void path(TableEntity tableEntity) {
        tableEntity.setApiEntityPath(GenUtil.getNowPath() + tableEntity.getApiEntityName() + ".java");
        tableEntity.setApiServicePath(GenUtil.getNowPath() + tableEntity.getApiServiceName() + ".java");
        tableEntity.setSerMapperPath(GenUtil.getNowPath() + tableEntity.getSerMapperName() + ".java");
        tableEntity.setSerImplPath(GenUtil.getNowPath() + tableEntity.getSerImplName() + ".java");
        tableEntity.setSerMapperXmlPath(GenUtil.getNowPath() + tableEntity.getSerMapperXmlName() + ".xml");
        tableEntity.setWebControllerPath(GenUtil.getNowPath() + tableEntity.getWebControllerName() + ".java");
        tableEntity.setSerDubboXmlPath(GenConfig.SER_DUBBO_XML_PATH);
        tableEntity.setWebDubboXmlPath(GenConfig.WEB_DUBBO_XML_PATH);
        tableEntity.setSerBeanXmlPath(GenConfig.SER_BEAN_XML_PATH);
    }

    //impl
    private static void impl(TableEntity tableEntity) {
        tableEntity.setApiEntityImport(tableEntity.getApiEntityName());
        tableEntity.setApiServiceImport(tableEntity.getApiServiceName());
        tableEntity.setSerMapperImport(tableEntity.getSerMapperName());
        tableEntity.setSerImplImport(tableEntity.getSerImplName());
        tableEntity.setSerMapperXmlImport(tableEntity.getSerMapperXmlName());
    }
    //Package
    private static void setPackage(TableEntity tableEntity) {
        tableEntity.setApiEntityPackage("");
        tableEntity.setApiServicePackage("");
        tableEntity.setSerMapperPackage("");
        tableEntity.setSerImplPackage("");
        tableEntity.setWebControllerPackage("");
    }
}
