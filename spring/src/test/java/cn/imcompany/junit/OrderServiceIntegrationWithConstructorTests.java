/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import cn.imcompany.test.OrderService;
import cn.imcompany.test.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringJUnitConfig(TestConfig.class)
public class OrderServiceIntegrationWithConstructorTests {

    private final OrderService orderService;

    // @Autowired
    public OrderServiceIntegrationWithConstructorTests(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    public void testOrder() {
        System.out.println(orderService);
    }

}
