package com.eric.spring.controller;

import com.eric.spring.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/info")
    public String paymentInfo(){
        return paymentService.paymentInfo();
    }

    @HystrixCommand(
            //请求异常/超时的处理方法
            fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {
            //限制超时时间3s
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping(value = "/payment/hystrix/timeout")
    public String paymentTimeout(){
        return paymentService.paymentTimeout();
    }

    public String paymentTimeoutHandler(){
        return "Hystrix handler.";
    }

    @GetMapping(value = "/payment/hystrix/circuit_breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
