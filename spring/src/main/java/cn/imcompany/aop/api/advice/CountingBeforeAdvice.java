/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class CountingBeforeAdvice implements MethodBeforeAdvice {

    private int count;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        count++;
        System.out.println("count: " + count);
    }

    public int getCount() {
        return count;
    }
}
