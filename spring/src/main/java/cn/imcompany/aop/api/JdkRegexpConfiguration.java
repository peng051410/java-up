/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api;

import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * With the JdkRegexpMethodPointcut class, you can provide a list of pattern strings. If any of these is a match, the pointcut evaluates to true.
 *
 * @author tomyli
 * @date 2025/1/14
 * enjoy
 */
@Configuration
public class JdkRegexpConfiguration {

    @Bean
    public JdkRegexpMethodPointcut settersAndAbsquatulatePointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*set.*|.*absquatulate.*");
        return pointcut;
    }
}
