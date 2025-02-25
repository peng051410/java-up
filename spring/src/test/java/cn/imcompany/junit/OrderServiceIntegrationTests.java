/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import cn.imcompany.test.OrderService;
import cn.imcompany.test.TestConfig;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@SpringJUnitConfig(TestConfig.class)
public class OrderServiceIntegrationTests {

    private final OrderService orderService;

    @Autowired
    public OrderServiceIntegrationTests(OrderService orderService) {
        this.orderService = orderService;
    }

    @Test
    public void testOrder() {
        System.out.println(orderService);
    }

    @Test
    void deleteOrder(@Autowired OrderService orderService) {
        // use orderService from the test's ApplicationContext
        System.out.println(orderService);
    }

    @RepeatedTest(10)
    void placeOrderRepeatedly(RepetitionInfo repetitionInfo,
                              @Autowired OrderService orderService) {

        System.out.println(repetitionInfo.getCurrentRepetition());
        System.out.println(orderService);
        // use orderService from the test's ApplicationContext
        // and repetitionInfo from JUnit Jupiter
    }

}
