/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.springframework.aop.ThrowsAdvice;

import java.rmi.RemoteException;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class RemoteThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(RemoteException ex) {
        System.out.println("RemoteThrowsAdvice afterThrowing");
    }
}
