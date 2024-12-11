/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tomyli
 * @date 2024/12/11
 * enjoy
 */
public class TestValueInject {

    @Test
    public void testProperties() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.value");
        Assertions.assertEquals("MovieCatalog", context.getBean(MovieRecommender.class).getCatalog());
    }

    @Test
    public void testCustomConverter() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.value");
        Assertions.assertEquals("666", context.getBean(MovieRecommender.class).getMycustom());
    }

    @Test
    public void testSpEL() {
        System.setProperty("user.catalog", "tomyli");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.value");
        Assertions.assertEquals("tomyli.catalog", context.getBean(MovieRecommenderV2.class).getCatalog());

        Assertions.assertEquals(100, context.getBean(MovieRecommenderV2.class).getGenreMap().get("Thriller"));
    }
}
