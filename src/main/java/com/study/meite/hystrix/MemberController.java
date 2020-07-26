package com.study.meite.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhenhong
 * @Description: 会员控制器类
 * @date 2020/7/26 19:54
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/memberIndex")
    public Object memberIndex() throws InterruptedException {
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", 200);
        hashMap.put("msg", "memberIndex");
        Thread.sleep(1500);
        return hashMap;
    }

}
