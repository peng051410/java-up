/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Collection;

/**
 *
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class ParamAdvice {

    @Before("execution(* cn.imcompany.aop.service.*.*(..)) && args(account)")
    public void before(String account) {
        System.out.println("before: " + account);
    }

    @Pointcut("execution(* cn.imcompany.aop.service.*.*(..)) && args(account)")
    public void verifyAccount(String account) {
    }

    @Before(value = "verifyAccount(account)", argNames = "account")
    public void beforeWithPointcut(String account) {
        System.out.println("beforeWithPointcut: " + account);
    }

    @Before("CommonPointcuts.businessService() && @annotation(auditable)")
    public void audit(Auditable auditable) {
        System.out.println("audit: " + auditable.value());
    }

    @Before("execution(* ..Sample+.sampleGenericMethod(*)) && args(param)")
    public void beforeGenericMethod(MyType param) {
        System.out.println("beforeGenericMethod: " + param);
    }

    @Before("execution(* ..Sample+.sampleGenericCollectionMethod(*)) && args(param)")
    public void beforeGenericCollectionMethod(Collection<?> param) {
        // Collection<MyType> param not work
        System.out.println("beforeGenericCollectionMethod: " + param);
    }
}
