/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2025/1/14
 * enjoy
 */
@Configuration
public class RegexpConfiguration {

    @Bean
    public RegexpMethodPointcutAdvisor settersAndAbsquatulateAdvisor(Advice beanNameAutoProxyCreator) {
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setAdvice(beanNameAutoProxyCreator);
        advisor.setPattern(".*set.*|.*absquatulate.*");
        return advisor;
    }
}
