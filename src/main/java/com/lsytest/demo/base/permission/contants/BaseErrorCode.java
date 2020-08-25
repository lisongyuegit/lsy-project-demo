package com.lsytest.demo.base.permission.contants;

/**
 * @describe: 错误号定义常量
 * @Copyright:(c) 2017
 * @company: 易登科技
 * @author: 雷军
 * @email：leijun@edenep.net
 * @version: 2.0
 * @date: 2017年10月21日
 * @time: 下午4:29:50
 */
public class BaseErrorCode {

    /**
     * 未知错误
     */
    public final static int UNKNOWN_ERROR = -99;

    /**
     * 请求非法
     */
    public final static int REQUEST_ERROR = -101;

    /**
     * 登录超时
     */
    public final static int REQUEST_TIME_OUT = -102;

    /**
     * 无访问权限
     */
    public final static int REQUEST_PERMISSION_ERROR = -103;

    public final static int VERIFICATION_CODE_ERROR = -1002;

}
