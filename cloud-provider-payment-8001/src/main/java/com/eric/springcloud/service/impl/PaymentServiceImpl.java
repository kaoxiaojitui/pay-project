package com.eric.springcloud.service.impl;

import com.eric.spring.entities.Payment;
import com.eric.springcloud.dao.PaymentDao;
import com.eric.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author eric.li
 * @date 2020/3/9
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 该Dao的实现使用的mybatis的xml，
     * 不在spring管理的bean中，故使用Java自带的Resource注解
     */
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment){
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
