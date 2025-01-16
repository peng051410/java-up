/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.api;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
public class TestStaticPointcut extends StaticMehodMatcherPointcut {

    @Override
    public boolean matches(String methodName) {
        return methodName.startsWith("get");
    }
}
