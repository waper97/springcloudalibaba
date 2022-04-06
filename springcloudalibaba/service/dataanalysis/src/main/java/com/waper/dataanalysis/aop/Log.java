package com.waper.dataanalysis.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 记录日志时的注解
 * @author wangpeng
 * @since 2022-4-2
 */
// ElementType.METHOD作用在方法上
@Target(ElementType.METHOD)
// 运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
