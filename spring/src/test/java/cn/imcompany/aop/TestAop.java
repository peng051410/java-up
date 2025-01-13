/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import cn.imcompany.aop.example.ProfilingService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tomyli
 * @date 2025/1/13
 * enjoy
 */
public class TestAop {

    @Test
    public void testAspectJLoadWeaver() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-aspectj.xml");
        ProfilingService service = context.getBean(ProfilingService.class);
        service.doSomething();
    }
}
