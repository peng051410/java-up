/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.DynamicPropertyRegistrar;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
@Configuration
public class DynamicPropertyRegistrarTest {

    @Bean
    ApiService apiService() {
        return new ApiService();
    }

    @Bean
    DynamicPropertyRegistrar apiProperties(ApiService apiService) {
        return registry -> {
            registry.add("api.host", apiService::getHost);
            registry.add("api.port", () -> 8080);
        };
    }
}
