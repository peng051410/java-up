/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @author tomyli
 * @date 2025/5/8
 * enjoy
 */
@Configuration
public class MyConfiguration {

    @Bean(name = {"myBean", "aBean"}, initMethod = "init", destroyMethod = "destroy")
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    @Description("This is a MyBean2 bean")
    public MyBean2 myBean2() {
        return new MyBean2();
    }
}
