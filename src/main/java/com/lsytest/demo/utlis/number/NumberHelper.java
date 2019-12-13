package com.lsytest.demo.utlis.number;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字帮助类
 */
public class NumberHelper {
    public static String numberCheck(Object obj,int num ,int decimal){
        if(null == obj || "".equals(obj.toString())){
            return "数据不能为空!";
        }
        try {
            BigDecimal big = new BigDecimal(obj.toString());
        } catch (Exception e) {
            return "数字输入有误!";
        }
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        String str = obj.toString();
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return "数字输入有误!";
        }
        String [] strArr = str.split("\\.");
        if(null != strArr[0] && strArr[0].length() > num){
            return "整数最大为:"+ num + " 位!";
        }

        if(strArr.length > 1 && strArr[1].length() > decimal){
            return "小数最大为:"+ decimal + " 位!";
        }
        return null;
    }
    public static void main(String[] args) {
      //  Pattern pattern = Pattern.compile("^(([1-9]\\d{0,9})|0)(\\.\\d{1,2})?$");

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入一个数据");
            String b = sc.next();
            try {
                String result = numberCheck(b, 4, 2);
                if(null == result){
                    System.out.println("验证通过");
                }else {
                    System.out.println("验证不通过: " + result);
                }
            }catch (Exception e){
                System.out.println("报错:" + e.getMessage());
            }

        }
    }
}
