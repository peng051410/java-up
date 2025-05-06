/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * database config
 * @author tomyli
 * @date 2025/4/29
 * enjoy
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public String appName() {
        return "appName";
    }
}
