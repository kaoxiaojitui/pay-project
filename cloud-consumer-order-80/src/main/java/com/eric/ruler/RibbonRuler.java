package com.eric.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eric.li
 * @date 2020/3/15
 */
@Configuration
public class RibbonRuler {

    @Bean
    public IRule randomRule(){
        return new RandomRule();
    }
}
