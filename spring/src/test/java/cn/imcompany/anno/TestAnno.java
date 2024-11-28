/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.anno;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2024/11/28
 * enjoy
 */
public class TestAnno {

    @Test
    public void testConstructor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.anno");
        context.getBean(FXNewsProviderWithConstructor.class).getAndPersistNews();
    }

    @Test
    public void testField() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.anno");
        context.getBean(FXNewsProvider.class).getAndPersistNews();
    }

    @Test
    public void testArbitraryMethod() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.anno");
        context.getBean(FXNewsProviderWithArbitraryMethod.class).getAndPersistNews();
    }

    @Test
    public void testQualifer() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.anno");
        context.getBean(FXNewsProviderQualifer.class).getAndPersistNews();
    }
}
