package com.eric.spring.controller;

import com.eric.common.entities.CommonResult;
import com.eric.spring.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/payment/discovery")
    public String getDiscovery(){
        return paymentFeignService.discovery().toString();
    }
}
