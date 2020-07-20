//package com.study.meite.boot.manyDataSource.config;
//
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
///**
// * @author lizhenhong
// * @Description: 读取配置文件信息(中读取mysql.datasource.test数据源)
// * @date 2020/7/19 21:25
// */
//@Data
//@ConfigurationProperties(prefix = "mysql.datasource.test")   //从配置文件中读取mysql.datasource.test数据源
//@Component
//public class DBConfig1 {
//
//    private String url;
//    private String username;
//    private String password;
//    private int minPoolSize;
//    private int maxPoolSize;
//    private int maxLifetime;
//    private int borrowConnectionTimeout;
//    private int loginTimeout;
//    private int maintenanceInterval;
//    private int maxIdleTime;
//    private String testQuery;
//
//}
