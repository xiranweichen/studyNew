package com.study.meite.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lizhenhong
 * @Description: 整合ftl页面
 * @date 2020/7/18 11:56
 */
@Controller
public class FtlIndexController {

    @RequestMapping("ftlIndex")
    public String ftlIndex() {
        return "index";
    }
}
