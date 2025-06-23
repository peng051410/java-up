/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tomyli
 * @date 2025/6/16
 * enjoy
 */
@Configuration
@Import({MyImportConfiguration.class})
@ComponentScan(basePackages = "cn.imcompany.bean.condition")
public class MyConfiguration {

    @Bean
    @ConditionalOnDate
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean2 myBean2() {
        return new MyBean2();
    }

    @Bean
    @Conditional(ConfigPropertyCondition.class)
    public MyBean5 myBean5() {
        return new MyBean5();
    }
}
