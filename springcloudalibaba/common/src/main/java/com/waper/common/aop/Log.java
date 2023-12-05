package com.waper.common.aop;



import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangpeng
 * @ClassName Log
 * @description TODO
 * @date 2023/11/22 11:58
 */
// 作用域方法上
@Target({ElementType.TYPE,ElementType.METHOD})
// 保留策略:保存class中，在jvm加载后仍然存在
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {


    /**
     *业务名称
     */

    String businessType() default "";

    /**
     * 模块名称
     */
    @AliasFor("name")
    String title() default "";

    /**
     * 业务说明
     */
    @AliasFor("title")
    String value() default "";
}
