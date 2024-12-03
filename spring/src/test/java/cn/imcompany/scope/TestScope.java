/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2024/12/3
 * enjoy
 */
public class TestScope {

    @Test
    public void testCustomScope() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.scope");
        context.getBean(MyThreadBean.class).doSomething();
        new Thread(() -> context.getBean(MyThreadBean.class).doSomething()).start();
        new Thread(() -> context.getBean(MyThreadBean.class).doSomething()).start();
        Thread.sleep(1000);
    }
}
