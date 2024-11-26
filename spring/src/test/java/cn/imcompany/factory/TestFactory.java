/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tomyli
 * @date 2024/11/22
 * enjoy
 */
public class TestFactory {

    @Test
    public void testMethodInject() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-static-factory.xml");
        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
        foo.say();
    }
}
