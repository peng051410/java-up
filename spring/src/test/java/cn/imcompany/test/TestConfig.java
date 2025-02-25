/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test;

import cn.imcompany.junit.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2025/2/12
 * enjoy
 *
 */
@Configuration
public class TestConfig {

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }
}
