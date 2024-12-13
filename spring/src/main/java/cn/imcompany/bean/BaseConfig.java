/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Bean;

/**
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
public interface BaseConfig {

    @Bean
    default String baseConfig() {
        return "baseConfig";
    }
}
