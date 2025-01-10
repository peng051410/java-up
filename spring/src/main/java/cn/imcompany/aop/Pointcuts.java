/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author tomyli
 * @date 2025/1/9
 * enjoy
 */
public class Pointcuts {

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Pointcut("within(cn.imcompany.aop..*)")
    public void inAopPackage() {
    }

    @Pointcut("publicMethod() && inAopPackage()")
    public void publicMethodInAopPackage() {
    }
}
