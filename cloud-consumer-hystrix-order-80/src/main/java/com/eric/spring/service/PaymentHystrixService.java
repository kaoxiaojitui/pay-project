package com.eric.spring.service;

import com.eric.spring.service.impl.PaymentFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Service
@FeignClient(value = "cloud-payment-service", fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/info")
    String paymentInfo();

    @GetMapping(value = "/payment/hystrix/timeout")
    String paymentTimeout();
}
