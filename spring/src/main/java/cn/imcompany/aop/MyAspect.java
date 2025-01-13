/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * one aspect instance is created for each unique service object that performs a business service
 *
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect("perthis(execution(* cn.imcompany.aop..service.*.**(..)))")
public class MyAspect {

    private int someState;

    @Before("execution(* cn.imcompany.aop..service.*.*(..))")
    public void before() {
        System.out.println("before");
    }
}
