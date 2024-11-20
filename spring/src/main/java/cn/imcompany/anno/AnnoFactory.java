/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2024/11/19
 * enjoy
 */
public class AnnoFactory {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.anno");
        context.getBean(FXNewsProvider.class).getAndPersistNews();
    }
}
