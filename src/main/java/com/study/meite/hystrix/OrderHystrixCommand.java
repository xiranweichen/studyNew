package com.study.meite.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lizhenhong
 * @Description: 通过线程池的方式实现 服务隔离
 *                  1、 使用线程池隔离可以完全隔离第三方应用，请求线程可以快速放回。
 *                  2、 请求线程可以继续接受新的请求，如果出现问题线程池隔离是独立的不会影响其他应用。 
 *                  3、 当失败的应用再次变得可用时，线程池将清理并可立即恢复，而不需要一个长时间的恢复。 
 *                  4、 独立的线程池提高了并发性
 *                  缺点： 
 *                  线程池隔离的主要缺点是它们增加计算开销（CPU）。每个命令的执行涉及到排队、调度和上 下文切换都是在一个单独的线程上运行的。
 * @date 2020/7/26 19:55
 */
public class OrderHystrixCommand  extends HystrixCommand<JSONObject> {  //泛型中的JSONObject: 表示服务返回的类型，要与业务服务一致

    @Autowired
    private MemberService memberService;

    /**
     * @param group
     */
    public OrderHystrixCommand(MemberService memberService) {
        super(setter());
        this.memberService = memberService;
    }

    /**
     * 这个是服务执行的代码
     * @return
     * @throws Exception
     */
    protected JSONObject run() throws Exception {
        JSONObject member = memberService.getMember();
        System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",订单服务调用会员服务:member:" + member);
        return member;
    }

    private static Setter setter() {

        // 服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("orders");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("orders");
        // 线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("member-pool");
        // #####################################################
        // 线程池配置 线程池大小为10,线程存活时间15秒 队列等待的阈值为100,超过100执行拒绝策略
        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter().withCoreSize(10)
                .withKeepAliveTimeMinutes(15).withQueueSizeRejectionThreshold(100);
        // ########################################################
        // 命令属性配置Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止
                .withExecutionTimeoutEnabled(false);
        return HystrixCommand.Setter.withGroupKey(groupKey).andCommandKey(commandKey).andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties).andCommandPropertiesDefaults(commandProperties);

    }

    /**
     * 服务降级
     * @return
     */
    @Override
    protected JSONObject getFallback() {
        // 如果Hystrix发生熔断，当前服务不可用,直接执行Fallback方法
        System.out.println("系统错误！");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 500);
        jsonObject.put("msg", "系统错误！");
        return jsonObject;
    }

}
