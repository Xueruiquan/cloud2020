package com.huiyuanai.springcloud.controller;

import com.huiyuanai.springcloud.entities.CommonResult;
import com.huiyuanai.springcloud.entities.Payment;
import com.huiyuanai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){ // 写
        log.info("****** 请求参数：" + payment.toString());
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功" + "serverPort:" + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败" + "serverPort:" + serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPahymentById(@PathVariable("id") Long id){
        log.info("****** 请求参数：" + id);
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果：" + result);
        if(result != null){
            return new CommonResult(200,"查询成功" + "serverPort:" + serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID：" + id + "，serverPort:" + serverPort,null);
        }
    }
}
