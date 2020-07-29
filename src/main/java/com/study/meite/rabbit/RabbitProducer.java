package com.study.meite.rabbit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: rabbit 生产者
 * @date: 2020/7/29 9:51
 * @author: lizhenhong
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void Producer_topics_springbootTest() {

        //使用rabbitTemplate发送消息
        String message = "send email message to user";
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM, 
                          "inform.email", 
                                      message);

    }


}
