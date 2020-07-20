package com.study;

//import com.study.meite.boot.manyDataSource.config.DBConfig1;
//import com.study.meite.boot.manyDataSource.config.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "com.study.meite.boot.mybatis")
//开启读取配置文件
//@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class LizhenhongApplication {

    public static void main(String[] args) {
        SpringApplication.run(LizhenhongApplication.class, args);
    }

}
