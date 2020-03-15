package com.eric.spring.controller;

import com.eric.spring.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallBack")
public class PaymentController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    //@HystrixCommand //未指明fallbackMethod则使用该类DefaultProperties配置的默认fallback
    @GetMapping(value = "/consumer/payment/info")
    public String getPaymentInfo(){
        return paymentHystrixService.paymentInfo();
    }


    @HystrixCommand(
            //请求异常/超时的处理方法
            fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {
                    //限制超时时间3s
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            })
    @GetMapping(value = "/consumer/payment/timeout")
    public String getPaymentTimeout(){
        // a = 10/0 //异常
        return paymentHystrixService.paymentTimeout();
    }

    public String paymentTimeoutHandler(){
        return "Order hystrix timeout rtn.";
    }

    public String paymentGlobalFallBack(){
        return "Default Order hystrix timeout rtn.";
    }
}
