package com.study.meite.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author lizhenhong
 * @Description: 自定义插入注解
 * @date 2020/7/4 0:36
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExtInsert {
    String value() default "";
}
