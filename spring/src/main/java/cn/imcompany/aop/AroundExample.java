/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class AroundExample {

    @Around("execution(* cn.imcompany.aop.service.*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object retVal = pjp.proceed();
        System.out.println("around after");
        return retVal;
    }
}
