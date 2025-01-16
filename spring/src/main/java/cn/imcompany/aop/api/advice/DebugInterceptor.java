/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class DebugInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before " + invocation.getMethod().getName());
        Object proceed = invocation.proceed();
        System.out.println("after " + invocation.getMethod().getName());
        return proceed;
    }
}
