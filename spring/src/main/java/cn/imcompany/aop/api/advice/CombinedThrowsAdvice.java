/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * If a throws-advice method throws an exception itself, it overrides the original exception
 *
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class CombinedThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RemoteException ex) {
        System.out.println("CombinedThrowsAdvice afterThrowing");
    }

    public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
        System.out.println("CombinedThrowsAdvice afterThrowing IllegalArgumentException");
    }
}
