/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/12
 * enjoy
 */
@SpringJUnitConfig
// ApplicationContext will be loaded from the static nested Config class
public class OrderServiceTest {

    // a test class can contain more than one static nested configuration class if desired.
    @Configuration
    static class Config {

        // this bean will be injected into the OrderServiceTest class
        @Bean
        OrderService orderService() {
            return new OrderService();
        }
    }

    @Autowired
    OrderService orderService;

    @Test
    void testOrderService() {
        orderService.printOrder();
    }
}
