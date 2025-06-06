/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2025/2/5
 * enjoy
 */
@Configuration
public class App1Config {

    @Bean
    public MyController myController() {
        return new MyController();
    }
}
