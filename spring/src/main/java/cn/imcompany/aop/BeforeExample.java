/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class BeforeExample {

    @Before(("execution(* cn.imcompany.aop.service.*.*(..))"))
    public void before() {
        System.out.println("before");
    }

    @Before("CommonPointcuts.inServiceLayer()")
    public void beforeInServiceLayer() {
        System.out.println("beforeInServiceLayer");
    }

}
