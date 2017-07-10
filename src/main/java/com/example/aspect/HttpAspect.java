package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by CGQ-PC on 2017/6/30.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //客户端IP
        logger.info("IP={}",request.getRemoteAddr());
        //服务器LocalIP
        logger.info("LocalIP={}",request.getLocalAddr());
        //服务器端口
        logger.info("ServerPort={}",request.getServerPort());
        //客户端LocalHost
        logger.info("LocalHost={}",request.getRemoteHost());
        //ServletPath
        logger.info("ServletPath={}",request.getServletPath());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //类方法2
        logger.info("class_method2={}",joinPoint.getSignature());
        //参数
        logger.info("class_args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("22222");
    }

    /*@AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterreturn(Object object){
        logger.info("return={}",object);
    }*/
}
