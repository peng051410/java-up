/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api.advice;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public interface Lockable {

    void lock();

    void unlock();

    boolean locked();
}
