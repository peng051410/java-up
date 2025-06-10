/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2025/6/5
 * enjoy
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyController myController = context.getBean(MyController.class);
        myController.showService();
        System.out.println(myController.getUsername());
    }
}
