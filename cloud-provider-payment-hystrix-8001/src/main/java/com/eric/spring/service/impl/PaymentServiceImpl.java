package com.eric.spring.service.impl;

import com.eric.spring.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo() {
        return "Thread : " + Thread.currentThread().getName();
    }

    @Override
    public String paymentTimeout() {
        try {
            // a = 10/0 //异常
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Thread : " + Thread.currentThread().getName();
    }
}
