/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2024/11/26
 * enjoy
 */
@Component
public class FooBar2 implements ApplicationContextAware {

    private ResourceLoader resourceLoader;

    public void foo(String location) {
        System.out.println(resourceLoader.getResource(location).getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.resourceLoader = applicationContext;
    }
}
