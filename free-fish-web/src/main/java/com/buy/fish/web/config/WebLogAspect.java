package com.buy.fish.web.config;

import com.alibaba.fastjson.JSON;
import com.buy.fish.common.pojo.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName WebLogAspect
 * @Description TODO
 * @Author xinjiakun
 * @Date 2020/2/8 18:32
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.buy.fish.controller.*.*(..))")
    public void webLog() {
    }

    /**
     *
     * @param joinPoint
     * @throws Throwable
     * AOP前置通知拦截请求参数信息
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL:" + request.getRequestURI().toString());
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }
    }

    /**
     *
     * @param result
     * @throws Throwable
     * AOP后置通知
     */
    @AfterReturning(returning = "result",pointcut = "webLog()")
    public void doAfterReturning(Result result) throws Throwable{
        logger.info("response:{},{},{}",result.getCode(),result.getMessage(), JSON.toJSONString(result.getResult()));
    }
}
