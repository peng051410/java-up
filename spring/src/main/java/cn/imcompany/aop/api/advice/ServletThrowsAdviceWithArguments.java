/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class ServletThrowsAdviceWithArguments implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
        System.out.println("ServletThrowsAdviceWithArguments afterThrowing IllegalArgumentException");
    }
}
