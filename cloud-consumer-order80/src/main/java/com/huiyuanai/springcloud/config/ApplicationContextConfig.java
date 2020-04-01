package com.huiyuanai.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 全局配置
 * @author: xue rui quan
 * @create: 2020-03-19 09:10
 */
@SpringBootConfiguration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
