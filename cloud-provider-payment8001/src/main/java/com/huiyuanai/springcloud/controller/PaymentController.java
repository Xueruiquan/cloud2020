package com.huiyuanai.springcloud.controller;

import com.huiyuanai.springcloud.entities.CommonResult;
import com.huiyuanai.springcloud.entities.Payment;
import com.huiyuanai.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 支付 控制层
 * @author: xue rui quan
 * @create: 2020-03-18 11:20
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient; // 通过服务发现获取eureka上的注册信息 注意要在启动了上添加@EnableDiscoveryClient

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) { // 写
        log.info("****** 请求参数：" + payment.toString());
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，" + "serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败" + "serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPahymentById(@PathVariable("id") Long id) {
        log.info("****** 请求参数：" + id);
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功", result);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID：" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices(); // 注册到Eureka上所有的服务，就是Eureka页面上的 Application
        for (String service : services) {
            log.info("注册到Eureka上的服务" + service);
        }
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE"); // 根据服务名称查询服务下所有的实例信息 对应的是Eureka页面上 Status 下的实例
//        for(ServiceInstance serviceInstance : serviceInstances){
//            log.info("CLOUD-ORDER-SERVICE 服务的实例：" + serviceInstance);
//        }
        List<ServiceInstance> serviceInstances1 = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"); // 根据服务名称查询服务下所有的实例信息 对应的是Eureka页面上 Status 下的实例
        for (ServiceInstance instance : serviceInstances1) {
            log.info("CLOUD-PAYMENT-SERVICE 服务的实例：" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
