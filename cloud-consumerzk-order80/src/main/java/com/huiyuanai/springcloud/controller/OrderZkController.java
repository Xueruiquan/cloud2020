package com.huiyuanai.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: xue rui quan
 * @create: 2020-04-04 14:35
 */
@RestController
public class OrderZkController {
    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplete; // 注入配置类中导入容器中的RestTemplate

    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplete.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
