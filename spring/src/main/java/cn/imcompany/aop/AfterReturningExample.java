/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class AfterReturningExample {

    // only works successfully
    @AfterReturning("execution(* cn.imcompany.aop.service.*.*(..))")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterReturning(value = "execution(* cn.imcompany.aop.service.*.*(..))", returning="retVal")
    public void afterReturningWithReturnVal(Object retVal) {
        System.out.println("afterReturning: " + retVal);
    }
}
