package com.eric.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author eric.li
 * @date 2020/3/16
 */
@SpringBootApplication
@EnableHystrixDashboard  //http://localhost:9001/hystrix  --> http://localhost:8001/actuator/hystrix.stream
public class ConsumerHystrixDashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoardMain9001.class, args);
    }
}
