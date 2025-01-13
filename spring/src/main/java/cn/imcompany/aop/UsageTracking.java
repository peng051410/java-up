/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

/**
 *
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
@Aspect
public class UsageTracking {

    @DeclareParents(value = "cn.imcompany.aop.*+", defaultImpl = DefaultUsageTracked.class)
    public static UsageTracked mixin;

    @Before("execution(* cn.imcompany.aop.service.*.*(..)) && this(usageTracked)")
    public void recordUsage(UsageTracked usageTracked) {
        usageTracked.incrementUseCount();
    }
}
