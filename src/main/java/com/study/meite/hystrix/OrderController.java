package com.study.meite.hystrix;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhenhong
 * @Description:  订单控制器类
 * @date 2020/7/26 19:48
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MemberService memberService;

    /**
     * 订单服务调用会员服务(底层使用RPC HTTPClient 技术)
     */
    @RequestMapping("/orderIndex")
    public Object orderIndex() throws InterruptedException {
        JSONObject member = memberService.getMember();
        System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",订单服务调用会员服务:member:" + member);
        return member;
    }

    /**
     * 订单服务调用会员服务, 解决服务雪崩效应，底层使用线程池隔离方式
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/orderIndexHystrix")
    public Object orderIndexHystrix() throws InterruptedException {
        JSONObject result = new OrderHystrixCommand(memberService).execute();
        return result;
    }

    @RequestMapping("/orderIndexHystrix2")
    public Object orderIndexHystrix2() throws InterruptedException {
        return new OrderHystrixCommand2(memberService).execute();
    }

    @RequestMapping("/findOrderIndex")
    public Object findIndex() {
        System.out.println("当前线程:" + Thread.currentThread().getName() + ",findOrderIndex");
        return "findOrderIndex";
    }

}
