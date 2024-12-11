/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.processor;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2024/12/9
 * enjoy
 */
class MyBeanPostConfigTest {

    @Test
    public void testBeanConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.processor");
        context.getBean(SimpleBean.class).doSomething();

    }

    @Test
    public void testMessage() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.processor");
        context.getBean(Messenger.class).send("hello");
    }


}
