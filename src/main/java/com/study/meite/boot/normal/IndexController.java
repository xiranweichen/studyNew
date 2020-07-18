package com.study.meite.boot.normal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2020/7/16 18:57
 * @author: lizhenhong
 */
@RestController //目的：这个注解相当于@ResponseBody+  @Controller, 使这个类所有的方法都返回json格式
@EnableAutoConfiguration //作用：开启自动装配到spring的bean容器中，加载pom中的jar包信息
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "真的是没有想到，这么简单的一个启动程序竟然搞了这么久，\n" +
                "这是我目前为止发现的idea2020.1的唯一坑点";
    }

    public static void main(String[] args) {
        //告诉 springboot 程序入口
        SpringApplication.run(IndexController.class, args);
    }
    
}
