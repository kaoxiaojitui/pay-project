package com.eric.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author eric.li
 * @date 2020/3/14
 */
@RestController
public class OrderZKController {
    @Autowired
    private RestTemplate restTemplate;

    private static String host = "http://cloud-provider-payment";

    @GetMapping(value = "/consumer/payment/zk")
    public String OrderToProviderByZK(){
        return restTemplate.getForObject(host+"/payment/zk", String.class);
    }
}
