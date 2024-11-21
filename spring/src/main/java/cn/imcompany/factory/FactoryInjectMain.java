/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import cn.imcompany.FXNewsProviderV2;
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

        System.out.println("start to testPrototypeBeans");
        testPrototypeBeans();
        System.out.println("end to testPrototypeBeans");

        System.out.println("start to testReplace");
        testReplace();
        System.out.println("end to testReplace");
    }

    private static void testReplace() {
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-config-factory-replace.xml");
        final FXNewsProviderV2 bean1 = applicationContext2.getBean(FXNewsProviderV2.class);
        bean1.getAndPersistNews();
    }

    private static void testPrototypeBeans() {
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-config-factory.xml");
        final MockNewsPersister bean = applicationContext2.getBean(MockNewsPersister.class);
        bean.persistNews();
        bean.persistNews();

        final MockNewsWithAwarePersister bean1 = applicationContext2.getBean(MockNewsWithAwarePersister.class);
        bean1.persistNews();
        bean1.persistNews();
        
        final MockNewsWithObjectFactoryPersister bean2 = applicationContext2.getBean(MockNewsWithObjectFactoryPersister.class);
        bean2.persistNews();
        bean2.persistNews();
    }
}
