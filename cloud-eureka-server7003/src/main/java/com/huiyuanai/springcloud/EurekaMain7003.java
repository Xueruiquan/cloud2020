package com.huiyuanai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: xue rui quan
 * @create: 2020-03-19 16:01
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7003.class, args);
        System.out.println("EurekaMain7003 启动成功， ｡:.ﾟヽ(｡◕‿◕｡)ﾉﾟ.:｡+ﾟ");
    }
}
