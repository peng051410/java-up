/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
public class PointExample {

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Pointcut("execution(* set*(..))")
    public void beginsWithSet() {
    }

    @Pointcut("execution(* cn.imcompany.aop.service.AccountService.*(..))")
    public void accountService() {
    }

    @Pointcut("execution(* cn.imcompany.aop.service.*.*(..))")
    public void anyServiceMethod() {
    }

    @Pointcut("execution(* cn.imcompany.aop.service..*.*(..))")
    public void anyServiceMethodAndSubPackage() {
    }

    // Spring AOP pointcut designators
    @Pointcut("within(cn.imcompany.aop.service.*)")
    public void inServicePackage() {
    }

    @Pointcut("within(cn.imcompany.aop.service..*)")
    public void inServicePackageAndSubPackage() {
    }

    @Pointcut("this(cn.imcompany.aop.service.AccountService)")
    public void proxyImplementsOfAccountService() {
    }

    @Pointcut("target(cn.imcompany.aop.service.AccountService)")
    public void targetImplementsOfAccountService() {
    }

    // Point with runtime arguments
    @Pointcut("args(java.io.Serializable)")
    public void argsWithSingleSerializable() {
    }

    // method accepting a single argument of type Serializable
    @Pointcut("execution(* *(java.io.Serializable))")
    public void methodAcceptingASerializable() {
    }

    @Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
    public void targetAnnotatedWithTransactional() {
    }

    @Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
    public void declareTypeHasAnnotatedWithTransactional() {
    }

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void methodAnnotatedWithTransactional() {
    }

    @Pointcut("@args(org.springframework.transaction.annotation.Transactional)")
    public void methodRuntimeTypeWithAnnotatedArgument() {
    }

    @Pointcut("bean(accountService)")
    public void beanNamedAccountService() {
    }

    @Pointcut("bean(*Service)")
    public void beanNameMatchService() {
    }
}
