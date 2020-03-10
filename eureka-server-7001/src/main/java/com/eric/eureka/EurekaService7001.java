package com.eric.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author eric.li
 * @date 2020/3/10
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService7001.class, args);
    }
}
