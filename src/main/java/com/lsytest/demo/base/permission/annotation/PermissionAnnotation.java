package com.lsytest.demo.base.permission.annotation;


import java.lang.annotation.*;

/**
 * 权限拦截
 *
 * @author 胡洪瑜 huhongyu@edenep.net
 * @version 2.0
 * @company 易登科技
 * @since 2017/12/8 14:56
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {
    PermissionType permissionType() default PermissionType.PERMISSION;
}
