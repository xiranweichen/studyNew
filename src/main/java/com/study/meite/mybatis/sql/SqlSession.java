package com.study.meite.mybatis.sql;

import com.study.meite.mybatis.aop.MyInvocationHandlerMbatis;

import java.lang.reflect.Proxy;

/**
 * @author lizhenhong
 * @Description: 自定义SqlSession
 * @date 2020/7/4 1:04
 */
public class SqlSession {

    // 获取mapper文件(接口)
    public static <T> T getMapper(Class<T> clas)
            throws IllegalArgumentException, InstantiationException, IllegalAccessException {
        return (T) Proxy.newProxyInstance(clas.getClassLoader(), new Class[] { clas },
                new MyInvocationHandlerMbatis(clas));
    }

}
