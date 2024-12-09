/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.scope;

import cn.imcompany.lifecycle.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tomyli
 * @date 2024/12/3
 * enjoy
 */
public class TestLifeCycle {

    @Test
    public void testInit() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-lifecycle.xml");
        BlogService blogService = context.getBean("blogService", BlogService.class);
        System.out.println(blogService);
    }
}
