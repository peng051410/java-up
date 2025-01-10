/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class AfterFinallyExample {

    @After("execution(* cn.imcompany.aop.service.*.*(..))")
    public void afterFinally() {
        System.out.println("afterFinally");
    }
}
