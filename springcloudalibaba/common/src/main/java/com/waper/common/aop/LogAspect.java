package com.waper.common.aop;

import cn.hutool.core.util.IdUtil;
import com.waper.common.entity.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

/**
 * 日志切面
 * @author wangpeng
 * @ClassName ApiLogAspect
 * @description 日志切面
 * @date 2023/11/20 14:31
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut(value = "@annotation(com.waper.common.aop.Log)")
    public void pointcut () {}

    /**
     * 异常切入点
     */
    @Pointcut("execution(* com.waper..controller..*.*(..))")
    public void exceptionLogPointCut () {}

    ThreadLocal<SystemLog> threadLocal = new ThreadLocal();

    @Around(value ="pointcut()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes)  RequestContextHolder.getRequestAttributes();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        Method method = methodSignature.getMethod();
        Log annotation = method.getAnnotation(Log.class);
        String value = annotation.value();
        String name = annotation.name();


        log.info("name:{}",name);
        log.info("value:{}",value);
        log.info("methodName:{}",methodName);
        log.info("method:{}",method);
        HttpServletRequest request = attributes.getRequest();
        log.info("：{path}",request.getPathInfo());
        log.info("：{url}",request.getRequestURI());
    }



    /**
     * 异常时
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "exceptionLogPointCut()",throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Throwable e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取注解
        Log annotation = signature.getMethod().getAnnotation(Log.class);
        String businessName = annotation.value();
        HttpServletRequest request = attributes.getRequest();
        long responseTime = System.currentTimeMillis();
        SystemLog systemLog = threadLocal.get();
        try {
            systemLog.setId(IdUtil.getSnowflakeNextId());
            String requestPath = request.getRequestURI();
            systemLog.setPath(requestPath);
            systemLog.setResponseBody(stackTraceToString( e.getClass().getName(), e.getMessage(),e.getStackTrace()));
            systemLog.setBusinessType(businessName);
            systemLog.setResponseTime(responseTime);
            systemLog.setBusinessProcessTime(responseTime - systemLog.getRequestTime());
            systemLog.setCreateTime(LocalDateTime.now());

            // 记录请求IP信息
            String clientIp = request.getRemoteAddr();
            String localhost = "127.0.0.1";
            String gateway = "0:0:0:0:0:0:0:1";
            if (clientIp.equals(localhost) || clientIp.equals(gateway)) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                }
                clientIp = inet.getHostAddress();
            }
            systemLog.setClientIp(clientIp);
//            dbISystemLogService.save(systemLog);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     *转化异常信息为字符串
     * @param exceptionName 异常名称
     * @param exceptionMessage 异常信息
     * @param elements 堆栈信息
     * @return
     */
    public static  String stackTraceToString (String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer buffer = new StringBuffer();
        for (StackTraceElement temp: elements){
            buffer.append(temp+"\n");
        }
        return exceptionName.concat(":").concat(exceptionMessage).concat("\n \t").concat(buffer.toString());
    }


}
