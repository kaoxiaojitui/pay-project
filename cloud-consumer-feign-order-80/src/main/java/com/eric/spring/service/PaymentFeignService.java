package com.eric.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    /**
     * 理解成ribbon + restTemplate 转换成接口实现
     * 只需要将服务名称加到FeignClient，提供接口内的路由调用及方法
     * 就可以完成服务调用
     * 即实现面向接口编程
     * FeignClient默认超时时间 1s
     */
    @GetMapping(value = "/payment/discovery")
    Object discovery();

}
