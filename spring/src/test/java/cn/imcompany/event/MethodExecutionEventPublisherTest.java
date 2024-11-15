/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.event;

import org.junit.jupiter.api.Test;

/**
 * @author tomyli
 * @date 2024/11/15
 * enjoy
 */
class MethodExecutionEventPublisherTest {

    MethodExecutionEventPublisher methodExecutionEventPublisher;

    @Test
    public void testPublisher() {
        methodExecutionEventPublisher.methodToMonitor();
    }

}
