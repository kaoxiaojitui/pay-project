package com.eric.spring.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        /**
         * logger level
         * FULL
         * HEADERS
         * BASIC
         * None
         */
        return Logger.Level.FULL;
    }
}
