package com.lsytest.demo.autocode.demo;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class GenConfig {
    public static final String TABLE_SQL = "CREATE TABLE `t_bus_high_tasks` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `task_id` varchar(50) NOT NULL COMMENT '任务id',\n" +
            "  `user_id` varchar(50) DEFAULT '101' COMMENT '用户id',\n" +
            "  `task_name` varchar(255) NOT NULL COMMENT '任务名称',\n" +
            "  `task_level` varchar(255) DEFAULT '1' COMMENT '任务等级',\n" +
            "  `task_status` varchar(255) DEFAULT '1' COMMENT '任务状态',\n" +
            "  `task_analysis` longtext,\n" +
            "  `task_progress` varchar(2048) DEFAULT NULL COMMENT '任务进展',\n" +
            "  `handle` varchar(255) DEFAULT NULL COMMENT '当前处理人',\n" +
            "  `start_date` varchar(60) DEFAULT NULL COMMENT '任务开始时间',\n" +
            "  `end_date` varchar(60) DEFAULT NULL COMMENT '任务结束时间',\n" +
            "  `create_date` varchar(60) DEFAULT NULL COMMENT '创建时间',\n" +
            "  `create_by` varchar(40) DEFAULT NULL COMMENT '创建人',\n" +
            "  `update_date` varchar(60) DEFAULT NULL COMMENT '更新时间',\n" +
            "  `update_by` varchar(40) DEFAULT NULL COMMENT '更新人',\n" +
            "  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=100 COMMENT='任务管理表';";
    public static final String MODULAR = "test";


    public static final String AUTHOR = "lisongyue@edenep.net";
    public static final String SER_BEAN_XML_PATH = "E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\java\\com\\lsytest\\demo\\autocode\\spring-lsy-project-demo.xml";
    public static final String SER_DUBBO_XML_PATH = "E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\java\\com\\lsytest\\demo\\autocode\\spring-lsy-project-demo.xml";
    public static final String WEB_DUBBO_XML_PATH = "E:\\LiSongYue\\MyCode\\LSY-PROJECT-DEMO\\lsy-project-demo\\src\\main\\java\\com\\lsytest\\demo\\autocode\\spring-lsy-project-demo.xml";
}
