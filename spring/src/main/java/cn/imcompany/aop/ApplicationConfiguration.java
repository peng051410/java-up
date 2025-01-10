/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author tomyli
 * @date 2025/1/9
 * enjoy
 */
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public NotVeryUsefulAspect myAspect() {
        return new NotVeryUsefulAspect();
    }

    @Pointcut("execution(* transfer(..))")
    private void anyOldTransfer() {
    }
}
