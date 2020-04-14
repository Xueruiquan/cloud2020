package com.huiyuanai.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 配置类
 * @author: xue rui quan
 * @create: 2020-04-14 19:15
 */
@Configuration
public class ApplicaitonContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){return new RestTemplate();}
}
