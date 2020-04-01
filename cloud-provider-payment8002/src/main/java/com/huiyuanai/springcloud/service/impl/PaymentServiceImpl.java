package com.huiyuanai.springcloud.service.impl;

import com.huiyuanai.springcloud.dao.PaymentDao;
import com.huiyuanai.springcloud.entities.Payment;
import com.huiyuanai.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 支付 服务 实现类
 * @author: xue rui quan
 * @create: 2020-03-18 11:17
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) { // 写
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) { // 读
        return paymentDao.getPaymentById(id);
    }
}
