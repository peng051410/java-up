/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class ArgumentNameAdvice {

    @Before(value = "CommonPointcuts.businessService() && target(bean) && @annotation(auditable)",
            argNames = "bean,auditable")
    public void audit(Object bean, Auditable auditable) {
        System.out.println("audit: " + bean.getClass().getName() + " " + auditable.value());
    }

    @Before(value = "CommonPointcuts.businessService() && target(bean) && @annotation(auditable)",
            argNames = "bean,auditable")
    public void auditWithJp(JoinPoint jp, Object bean, Auditable auditable) {
        System.out.println("audit: " + bean.getClass().getName() + " " + auditable.value());
    }

    @Before("CommonPointcuts.businessService()")
    public void audit(JoinPoint jp) {
        System.out.println("audit: " + jp.getSignature().getName());
    }

    @Around("execution(java.util.List<Account> find*(..)) && CommonPointcuts.dataAccessOperation() && args(accountHolderNamePattern)")
    public Object around(ProceedingJoinPoint pjp, String accountHolderNamePattern) throws Throwable {
        String newPattern = preProcess(accountHolderNamePattern);
        return pjp.proceed(new Object[]{newPattern});
    }

    private String preProcess(String accountHolderNamePattern) {
        return "newPattern";
    }
}
