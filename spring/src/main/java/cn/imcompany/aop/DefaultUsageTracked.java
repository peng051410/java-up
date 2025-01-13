/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop;

/**
 * @author tomyli
 * @date 2025/1/10
 * enjoy
 */
public class DefaultUsageTracked implements UsageTracked {

    @Override
    public void incrementUseCount() {
        System.out.println("incrementUseCount");
    }
}
