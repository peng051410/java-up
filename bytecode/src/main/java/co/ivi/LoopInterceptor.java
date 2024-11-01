/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

/**
 * @author tomyli
 * @date 2024/10/25
 * enjoy
 */
public class LoopInterceptor {

    @RuntimeType
    public static Object intercept(@RuntimeType Object value) {
        System.out.println("intercepted: " + value);
        return value;
    }
}
