package com.study.meite.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author lizhenhong
 * @Description: 自定义参数注解
 * @date 2020/7/4 0:40
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ExtParam {
    String value();
}
