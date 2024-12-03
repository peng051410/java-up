/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2024/12/3
 * enjoy
 */
@Configuration
public class ScopeConfig {
    
    /**
     * The customScopeConfigurer method is marked as static to ensure that the CustomScopeConfigurer bean is created and registered early in the Spring container lifecycle. This is important because custom scopes need to be available before any other beans that use those scopes are created.
     */
    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("myScope", new MyScope());
        return customScopeConfigurer;
    }
}
