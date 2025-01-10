/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class AfterThrowingExample {

    @AfterThrowing("execution(* cn.imcompany.aop.service.*.*(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @AfterThrowing(value = "execution(* cn.imcompany.aop.service.*.*(..))", throwing="ex")
    public void afterThrowingWithException(ArrayIndexOutOfBoundsException ex) {
        System.out.println("afterThrowing: " + ex);
    }
}
