package com.eric.spring.service.impl;

import com.eric.spring.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",
    commandProperties = { //断路器开启后，会在后续的请求中判断请求是否响应成功，且缓慢回复服务
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//条件限定的请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//条件限定的时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//条件限定失败率

    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0){
            throw new NullPointerException();
        }
        return "Circuit Breaker success.";
    }

    /**
     * fall back 方法参数需要保持与实现方法参数一致
     */
    public String paymentCircuitBreakerFallBack(Integer id){
        return "Circuit Breaker failed." + id;
    }
}
