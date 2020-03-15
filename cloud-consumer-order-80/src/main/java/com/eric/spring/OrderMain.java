package com.eric.spring;

import com.eric.ruler.RibbonRuler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author eric.li
 * @date 2020/3/9
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-service", configuration = RibbonRuler.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }
}
