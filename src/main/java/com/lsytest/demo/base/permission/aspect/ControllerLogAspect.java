package com.lsytest.demo.base.permission.aspect;

import com.alibaba.fastjson.JSON;
import com.lsy.base.net.IPAddressHelper;
import com.lsy.base.string.StringHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @describe: spring-boot aop 统一日志切面
 * @Copyright:(c) 2017
 * @company: 易登科技
 * @author: 雷军
 * @email：leijun@edenep.net
 * @version: 2.0
 * @date: 2017年10月20日
 * @time: 上午11:17:34
 */
@Aspect
@Order(2)
@Component
public class ControllerLogAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.GetMapping)" + "|| " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void controllerLog() {
    }

    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String curUserId = request.getParameter("curUserId");
        // 请求路径
        String requestUrl = request.getRequestURL().toString();
        // 请求方式
        String requestMethod = request.getMethod();
        // IP
        String ip = IPAddressHelper.getClientIPAddress(request);
        String functionName = joinPoint.getSignature().getName();
        // 接口名称
        String serviceName = String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(), functionName);
        // 入参
        Map<String, String> map = new HashMap<>(16);
        Enumeration paramNames = request.getParameterNames();
        String paramName;
        String[] paramValues;
        String paramValue;
        while (paramNames.hasMoreElements()) {
            paramName = (String) paramNames.nextElement();
            paramValues = request.getParameterValues(paramName);
            if (paramValues.length > 0) {
                paramValue = paramValues[0];
                if (StringHelper.isNotBlank(paramValue)) {
                    map.put(paramName, paramValue);
                }
            }
        }
        logger.info("请求地址 : " + requestUrl);
        logger.info("请求方法 : " + requestMethod);
        logger.info("IP : " + ip);
        logger.info("请求服务 : " + serviceName);
        String inParams = JSON.toJSONString(map);
        logger.info("接口入参 : " + inParams);
        Object proceed = null;
        Exception ee = null;

        try {
            Object[] args = joinPoint.getArgs();
            proceed = joinPoint.proceed(args);
        } catch (Exception e) {
            ee = e;
        }

        logger.info("接口出参 : " + JSON.toJSONString(proceed));
        logger.info("响应时间 : " + (System.currentTimeMillis() - startTime.get()));

        if (ee != null) {
            throw ee;
        }
        return proceed;
    }

}
