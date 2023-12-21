package com.waper.dataanalysis.aop;

import com.waper.dataanalysis.model.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @ClassName LogAop
 * @Description TODO
 * @Author wangpeng
 * @Date 2022/4/2 10:03
 */
// 表明是一个切面类
@Aspect
@Component
public class LogAop {
    /** && @annotation(log))**/
    @Pointcut("execution(* com.waper.dataanalysis.controller..*(..))")
    private void pointCut () {

    }
//    @Autowired
//    LogMapper logMapper;

    @Around("execution(* com.waper.dataanalysis.controller..*(..))")
    public Object recordLog (ProceedingJoinPoint proceedingJoinPoint/**, Log log**/) throws Throwable {
        System.out.println("环绕通知!");
       return  proceedingJoinPoint.proceed();

    }

    @Before("pointCut()")
    public void before () {
        System.out.println("后置通知!");
    }


    @After("pointCut()")
    public void after () {
        System.out.println("前置通知!");

        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setErrorMessage("进入了方法");
        log.setCreateTime(LocalDateTime.now());
        log.setModule("dataanalysis");
//        logMapper.save(log);
    }


}
