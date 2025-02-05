/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.proxy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
@Setter
@Getter
public class MyAdvisor implements MethodBeforeAdvice {
    private String someProperty;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before");
    }
}
