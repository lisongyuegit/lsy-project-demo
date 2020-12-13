package com.lsytest.demo.autocode;

import com.lsytest.demo.autocode.demo.*;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class RunGen {
    public static void main(String[] args) {
        FileCons fileCons = AnalysisTable.start(GenConfig.TABLE_SQL);
        System.out.println("数据表解析完成");
        GenFileContent.startGenFileContent(fileCons);
        System.out.println("数据组装完成");
        GenFile.startGenFile(fileCons);
        System.out.println("文件生成完成");
    }
}
