package com.lsytest.demo.base.permission.aspect;

import com.lsy.base.exception.BusinessException;
import com.lsy.base.string.StringHelper;
import com.lsy.redis.client.JedisClient;
import com.lsytest.demo.base.permission.annotation.PermissionAnnotation;
import com.lsytest.demo.base.permission.annotation.PermissionType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限切面
 *
 * @author 胡洪瑜 huhongyu@edenep.net
 * @version 2.0
 * @copyright Copyright (c) 2017
 * @since
 */
@Aspect
@Order(1)
@Component
public class PermissionAspect {

    //    @Autowired
//    private IApplicationService applicationService;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JedisClient redisClient = JedisClient.getJedisClient();

    @Before("@annotation(permissionAnnotation)")
    public void doBefore(final JoinPoint joinPoint, PermissionAnnotation permissionAnnotation) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String requestUrl = request.getRequestURI().toString();
        String curImei = request.getParameter("curImei");
        boolean isFromApp = StringHelper.isNotBlank(curImei);
        String curMerchantId = request.getParameter("curMerchantId");

        if (StringHelper.isBlank(curMerchantId)) {
            throw new BusinessException(-1, "[curMerchantId[不能为空");
        }
        String curUserId = request.getParameter("curUserId");
        if (StringHelper.isBlank(curUserId)) {
            throw new BusinessException(-1, "[curUserId]不能为空");
        }

        if (permissionAnnotation.permissionType().equals(PermissionType.NONE)) {
            logger.info("裸奔的接口，不需要拦截");
        } else if (permissionAnnotation.permissionType().equals(PermissionType.LOGIN)) {
            logger.info(String.format("半裸奔的接口，需要做登录校验，请求的地址为：%s", requestUrl));
            checkToken(request, requestUrl);
        } else if (permissionAnnotation.permissionType().equals(PermissionType.PERMISSION)) {
            logger.info(String.format("非裸奔的接口，需要做登录和权限校验，请求的地址为：%s", requestUrl));
            checkToken(request, requestUrl);
        }
    }

    /**
     * 校验Token
     *
     * @param request
     * @param requestUrl
     */
    private void checkToken(HttpServletRequest request, String requestUrl) {
        String curMerchantId = request.getParameter("curMerchantId");
        String merId = "";
//        if (StringHelper.isNotBlank(curMerchantId)) {
//            String platMerchantInfoKey = String.format(RedisContantKey.PLAT_MERCHANT_INFO, curMerchantId);
//            //如果缓存没有就去查数据库
//            if (!redisClient.exists(platMerchantInfoKey)) {
//                EntityWrapper<SysMerchant> queryWrapper = new EntityWrapper<>();
//                queryWrapper.eq("merchant_id", curMerchantId);
//                SysMerchant respMerchant = merchantService.selectOne(queryWrapper);
//                if (null == respMerchant) {
//                    throw new BusinessException(-1, "商户信息不存在");
//                }
//                merId = String.valueOf(respMerchant.getId());
//            }
//        }
//        String curUserId = request.getParameter("curUserId");
//        String curToken = request.getParameter("userToken");
//        String t_plat_user_token_referer = String.format(RedisContantKey.PLAT_USER_TOKEN_KEY, merId, curUserId);
//        String userToken = redisClient.getString(t_plat_user_token_referer);
//
//        if (StringHelper.isBlank(userToken)) {
//            throw new BusinessException(BaseErrorCode.REQUEST_TIME_OUT, "因您长时间未操作，系统自动退出登录，请重新登录！");
//        }
//        if (!curToken.equals(userToken)) {
//            throw new BusinessException(BaseErrorCode.REQUEST_ERROR, "您的账号已在其它设备登录，如非本人操作请重新登录并及时修改密码！");
//        }

        //更新token有效时间
     //   redisClient.expire(t_plat_user_token_referer, SystemContant.USER_TOKEN_TIME_OUT);
    }

//    private void checkPermission(HttpServletRequest request, String requestUrl) {
//        String curMerchantId = request.getParameter("curMerchantId");
//        String curUserId = request.getParameter("curUserId");
//        String curApplicationCode = request.getParameter("curApplicationCode");
//
//        String t_plat_user_res_referer = String.format(RedisContantKey.PLAT_USER_RESOURCE_URL
//                + RedisContantKey.T_PLAT_MCH_USER_KEY_HOST, curMerchantId, curUserId);
//        String resInfo = redisClient.hget(t_plat_user_res_referer, requestUrl);
//
//        if (StringHelper.isBlank(resInfo)) {
//            //1.判断该模块是否需要权限校验
//            String application_referer = RedisContantKey.PLAT_APP_INFO;
//            String objString = redisClient.hget(application_referer, curApplicationCode);
//
//            if (StringHelper.isBlank(objString)) {
//                applicationService.synAllAppliaction();
//                objString = redisClient.hget(application_referer, curApplicationCode);
//                if (StringHelper.isBlank(objString)) {
//                    throw new BusinessException(BaseErrorCode.REQUEST_PERMISSION_ERROR, "无接口访问权限");
//                }
//            } else {
//                JSONObject obj = JSON.parseObject(objString);
//                Application app = JSON.toJavaObject(obj, Application.class);
//                if (BooleanEnum.TRUE.getValue().equals(app.getIsPermission())) {
//                    throw new BusinessException(BaseErrorCode.REQUEST_PERMISSION_ERROR, "无接口访问权限");
//                } else {
//                    String appInfo = redisClient.hget(t_plat_user_res_referer, app.getApplicationServerPath());
//                    if (StringHelper.isBlank(appInfo)) {
//                        throw new BusinessException(BaseErrorCode.REQUEST_PERMISSION_ERROR, "无接口访问权限");
//                    }
//                }
//            }
//        }
//    }

}
