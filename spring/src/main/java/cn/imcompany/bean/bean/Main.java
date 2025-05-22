/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2025/5/8
 * enjoy
 */
public class Main {

    public static void main(String[] args) {
        // 1. 创建 Spring 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.bean.bean");
        System.out.println(context.getBean(MyBean.class));
        context.close();
    }
}
