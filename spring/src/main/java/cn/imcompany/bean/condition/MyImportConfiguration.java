/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author tomyli
 * @date 2025/6/17
 * enjoy
 */
@Configuration
@Conditional(ImportConfigPropertyCondition.class)
public class MyImportConfiguration {

    @Bean
    public MyBean6 myBean6() {
        return new MyBean6();
    }
}
