package com.lsytest.demo.autocode.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class GenUtil {
    public static void main(String[] args) {
        String  resp = getEntityName("t_update_date_time");
        System.out.println(resp);
    }
    public static String typeTran(String reqStr) {
        if(reqStr.contains("int")){
            return "Integer";
        }else{
            return "String";
        }
    }
    public static String replace(String reqStr) {
        reqStr = reqStr.replace("`","");
        reqStr = reqStr.replace("'","");
        return reqStr;
    }
    public static String getAttribute(String reqStr) {
        reqStr = replace(reqStr);
        String[] strings = reqStr.split("_");
        if(strings.length <= 1){
            return strings[0];
        }
        String respStr = "";
        for(int i = 0; i < strings.length ; i++){
            if(i == 0){
                respStr = respStr+strings[i];
            }else {
                respStr = respStr+titleCase(strings[i]);
            }

        }
        return respStr;
    }
    public static String getEntityName(String reqStr) {
        reqStr = replace(reqStr);
        String[] strings = reqStr.split("_");
        String respStr = "";
        for(int i = 1; i < strings.length ; i++){
                respStr = respStr+titleCase(strings[i]);

        }
        return respStr;
    }


    public static String titleCase(String reqStr) {
        String respStr = reqStr.substring(0, 1).toUpperCase() + reqStr.substring(1);
        return respStr;
    }

    public static String titleLower(String reqStr) {
        String respStr = reqStr.substring(0, 1).toLowerCase() + reqStr.substring(1);
        return respStr;
    }

    public static String getNowPath() {
        String nowPath = System.getProperty("user.dir") + "\\lsy-project-demo\\src\\main\\java\\com\\lsytest\\demo\\autocode\\";
        System.out.println("当前项目路径为" + nowPath);
        return nowPath;
    }

    public static void tihuan(String fileUrl, String replaceSource, String replaceTarget) {
        try {
            File file = new File(fileUrl);
// 建立一个file对象，参数就是你想访问文件的路径，这里我就不验证文件是否存在了
// 查下api即可
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            List list = new ArrayList();
//定义一个集合存放每一行的字符串
            while (true) {
                String str = br.readLine();
//读取文件当中的一行
                if (str == null) break;
//如果读取的是空，也就是文件读取结束 跳出循环
                int index = str.indexOf(replaceTarget);
//看此行的是否包含zhidao
                if (index != -1) {
                    str = str.replace(replaceTarget, replaceSource);
//如果包含就把zhidao 换成answer
                }
                list.add(str);
//把修改之后的str放到集合当中
            }
            br.close();
            PrintWriter pw = new PrintWriter(file);
//建立一个输出流，把东西写入文件
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
//从集合当中取出字符串
                pw.println(str);
//把该字符串写入文件当中
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
