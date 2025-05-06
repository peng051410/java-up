/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import cn.imcompany.aop.proxy.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testcontainers.shaded.com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author tomyli
 * @date 2025/1/13
 * enjoy
 */
public class TestAop {

    @Test
    public void testAspectJLoadWeaver() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> partition = Lists.partition(list, 2);
        System.out.println(partition.size());

        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-aspectj.xml");
        // ProfilingService service = context.getBean(ProfilingService.class);
        // service.doSomething();
    }

    @Test
    public void testProxyFactoryBean() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-bean.xml");
        Person bean = context.getBean(Person.class);
        assertNotNull(bean);
        System.out.println(bean.getClass());
    }
    @Test
    public void testProxyFactoryInnerBean() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-inner-bean.xml");
        Person bean = context.getBean(Person.class);
        assertNotNull(bean);
        System.out.println(bean.getClass());
    }
}
