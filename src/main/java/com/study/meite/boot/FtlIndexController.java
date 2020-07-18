package com.study.meite.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhenhong
 * @Description: 整合ftl页面
 * @date 2020/7/18 11:56
 */
@RestController
@RequestMapping("/ftlIndex")
public class FtlIndexController {

    @Value("${http_url}")
    private String http_url;

    @RequestMapping("ftlIndex")
    public String getFtlIndex() {
        return "index";
    }

    @RequestMapping("/getHttp_url")
    @ResponseBody
    public String getHttp_url() {
        return http_url;
    }


}
