/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class FactoryInjectMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-static-factory.xml");
        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
        foo.say();

        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-factory.xml");
        Foo foo2 = applicationContext2.getBean(Foo.class);
        foo2.sayZoo();
    }
}
