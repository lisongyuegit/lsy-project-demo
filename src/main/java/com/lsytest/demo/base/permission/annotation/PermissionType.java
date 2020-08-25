package com.lsytest.demo.base.permission.annotation;

/**
 * @author 胡洪瑜 huhongyu@edenep.net
 * @version 2.0
 * @company 易登科技
 * @since 2017/12/8 14:59
 */
public enum PermissionType {
    // 不做拦截
    NONE,
    // 登录拦截
    LOGIN,
    // 配置权限拦截
    PERMISSION,;

    PermissionType() {
    }
}
