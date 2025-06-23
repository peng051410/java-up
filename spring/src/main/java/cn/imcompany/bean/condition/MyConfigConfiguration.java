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
@Conditional(ConfigPropertyCondition.class)
public class MyConfigConfiguration {

    @Bean
    public MyBean3 myBean3() {
        return new MyBean3();
    }

    @Bean
    public MyBean4 myBean4() {
        return new MyBean4();
    }
}
