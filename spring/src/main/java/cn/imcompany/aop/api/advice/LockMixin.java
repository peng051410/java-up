/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {

    private boolean locked;

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public boolean locked() {
        return this.locked;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        if (locked() && mi.getMethod().getName().indexOf("set") == 0) {
            throw new LockedException("Cannot invoke set() on a locked Lockable");
        }
        return super.invoke(mi);
    }
}
