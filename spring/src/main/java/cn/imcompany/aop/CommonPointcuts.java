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
public class CommonPointcuts {

    @Pointcut("within(cn.imcompany.aop.web..*)")
    public void inWebLayer() {
    }

    @Pointcut("within(cn.imcompany.aop.service..*)")
    public void inServiceLayer() {
    }

    @Pointcut("within(cn.imcompany.aop.dao..*)")
    public void inDataAccessLayer() {
    }

    @Pointcut("execution(* cn.imcompany..service.*.*(..))")
    public void businessService() {
    }

    @Pointcut("execution(* cn.imcompany..dao.*.*(..))")
    public void dataAccessOperation() {
    }

}
