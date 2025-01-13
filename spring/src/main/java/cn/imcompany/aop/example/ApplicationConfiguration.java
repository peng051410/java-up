/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public ConcurrentOperationExecutor concurrentOperationExecutor() {
        ConcurrentOperationExecutor executor = new ConcurrentOperationExecutor();
        executor.setMaxRetries(3);
        executor.setOrder(100);
        return executor;
    }
}
