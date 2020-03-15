package com.eric.spring.service.impl;

import com.eric.spring.service.PaymentHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Service
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo() {
        return "fall back info";
    }

    @Override
    public String paymentTimeout() {
        return "fall back timeout";
    }
}
