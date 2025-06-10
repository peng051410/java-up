/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.bean;

import org.springframework.context.annotation.Bean;

/**
 * Base configuration interface for defining beans.
 *
 * @author tomyli
 * @date 2025/6/10
 * enjoy
 */
public interface BaseConfig {

    @Bean
    default MyBean3 myBean3() {
        return new MyBean3();
    }

}
