/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import org.springframework.beans.factory.FactoryBean;
import cn.imcompany.FXNewsProviderV2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class FactoryInjectMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-static-factory.xml");
        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo);
        foo.say();

        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("spring-factory.xml");
        Foo foo2 = applicationContext2.getBean(Foo.class);
        foo2.sayZoo();

        ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext("spring-factory-factorybean.xml");
        Object obj = applicationContext3.getBean("dateOfNextDay");
        System.out.println(obj instanceof LocalDate);
        Object objBean = applicationContext3.getBean("&dateOfNextDay");
        System.out.println(objBean instanceof FactoryBean);
        System.out.println(objBean instanceof NextDayFactoryBean);

        Object factoryValue = ((FactoryBean) objBean).getObject();
        System.out.println(factoryValue instanceof LocalDate);

        System.out.println(obj == factoryValue);
        System.out.println(((LocalDate) obj).getDayOfYear() == ((LocalDate) factoryValue).getDayOfYear());

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
