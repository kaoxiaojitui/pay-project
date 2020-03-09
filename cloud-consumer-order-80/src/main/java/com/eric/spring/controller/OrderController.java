package com.eric.spring.controller;

import com.eric.spring.entities.CommonResult;
import com.eric.spring.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author eric.li
 * @date 2020/3/9
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private static String host = "http://localhost:8001";

    @PostMapping(value = "/consumer/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        return restTemplate.postForObject(host + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(host + "/payment/get/" + id, CommonResult.class);
    }
}
