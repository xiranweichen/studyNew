package com.study.meite.hystrix;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author lizhenhong
 * @Description: 会员逻辑层
 * @date 2020/7/26 19:50
 */
@Service
public class MemberService {

    public JSONObject getMember() {

        JSONObject result = HttpClientUtils.httpGet("http://127.0.0.1:8081/member/memberIndex");
        return result;
    }

}
