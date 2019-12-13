package com.lsytest.demo.testrun;

import com.alibaba.fastjson.JSONObject;
import com.lsytest.demo.constant.ExcelHeaderContants;

public class TestRun {
    public static void main(String[] args) {

//        try {
//            File newFile = new File("D:/hk/a.txt");
//            if(!newFile.exists()){
//                try {
//                    if(newFile.createNewFile()){
//                        System.out.println("创建文件成功");
//
//                    }else{
//                        System.out.println("创建文件失败");
//                    }
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("文件新建成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String[]  aa = ExcelHeaderContants.EXCEL_HEADER_HR;


        String[] values = new String[ExcelHeaderContants.EXCEL_HEADER_HR_COLUMNS];
        for (int i = 0; i < ExcelHeaderContants.EXCEL_HEADER_HR_COLUMNS; i++) {
            values[i] = ExcelHeaderContants.EXCEL_HEADER_HR[i];
        }

        System.out.println("111111 : "+ ExcelHeaderContants.EXCEL_HEADER_HR_COLUMNS);
        System.out.println("222222 : "+ JSONObject.toJSON(ExcelHeaderContants.EXCEL_HEADER_HR));
        System.out.println("333333 : "+ JSONObject.toJSON(values));

    }
    private void testStr(){

    }
    private void testIdcard(){
        //验证身份证号码
        //boolean result = IdcardUtils.validateCard("430224199208163312");
        String str = "所属机构（必选）";
        str = "所属机构";
        String [] strArr = str.split("（");
        for(int i = 0 ; i < strArr.length ; i++){
            System.out.println(i + " : " + strArr[i]);
        }
        str = "试用期（月）";
        String str1 = "";
        flag:
        for (int i = 0; i < 10; i++) {
            switch (str){
                case "1" :
                    str1 = "1";
                    break;
                case  "2" :
                    str1 = "2";
                    break;
                case "试用期（月）":
                    str1 = "3";
                default:
                    str1 = "0";
                    continue flag;

            }
        }

    }
}
