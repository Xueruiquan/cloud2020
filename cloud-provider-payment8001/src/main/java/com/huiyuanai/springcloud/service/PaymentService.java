package com.huiyuanai.springcloud.service;

import com.huiyuanai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 支付 服务
 * @author: xue rui quan
 * @create: 2020-03-18 11:16
 */
public interface PaymentService {
    public int create(Payment payment); // 写

    public Payment getPaymentById(@Param("id") Long id); // 读
}
