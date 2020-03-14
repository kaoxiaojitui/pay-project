package com.eric.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eric.li
 * @date 2020/3/14
 */
@RestController
public class PaymentController {

    @GetMapping(value = "payment/zk")
    public String zookeeperRegisterTest(){
        return "spring cloud with zookeeper.";
    }
}
