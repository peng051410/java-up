/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2025/6/16
 * enjoy
 */
public class Main {

    public static void main(String[] args) {

        System.setProperty("my.config.property", "true");
        System.setProperty("my.config.import", "true");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
