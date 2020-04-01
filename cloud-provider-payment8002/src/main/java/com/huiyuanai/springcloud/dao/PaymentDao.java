package com.huiyuanai.springcloud.dao;

import com.huiyuanai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @description: 支付 数据访问
 * @author: xue rui quan
 * @create: 2020-03-18 10:53
 */
@Mapper
@Component
public interface PaymentDao {
    public int create(Payment payment); // 写

    public Payment getPaymentById(@Param("id") Long id); // 读
}
