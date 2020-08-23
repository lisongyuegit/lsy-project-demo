package com.lsytest.demo.base.utils;

import com.lsytest.demo.base.enums.OrderTypeEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: lisongyue@edenep.net
 * @company: Eden Technology
 * @motto: 代码也可以是一种艺术
 * @version: 1.0
 * @date: 2019/10/9 21:05
 */
public class ComUtil {

    /**
     * 生成订单编号
     *
     * @return
     * @description: 年月日时分秒 + 两位数的订单类型 + 4位随机数（不够补0）
     */
    public static String generateOrderNo(OrderTypeEnum orderTypeEnum) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int number = (int) (Math.random() * (9999 - 1) + 1);
        String numberStr = String.format("%04d", number);
        String orderNo = String.format("%s%s%s", dateTime, orderTypeEnum.getValue(), numberStr);
        return orderNo;
    }
    /**
     * 生成订单编号
     *
     * @return
     * @description: 年月日时分秒 + 两位数的订单类型 + 4位随机数（不够补0）
     */
    public static String getNo() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return dateTime;
    }
    /**
     * Object 转 String
     *
     * @param obj
     * @return
     */
    public static String objToStr(Object obj) {
        if (null == obj) {
            return "";
        }
        return obj.toString();
    }

    public static void main(String[] args) {
        System.out.println("111"+getNo());
    }
}
