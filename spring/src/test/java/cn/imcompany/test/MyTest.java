/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test;

import org.springframework.test.context.TestExecutionListeners;

/**
 * @author tomyli
 * @date 2025/2/12
 * enjoy
 */
// Switch to default listeners
@TestExecutionListeners(
        inheritListeners = false,
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS
)
public class MyTest extends BaseTest {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public void test() {
        System.out.println("Hello, World!");
    }
}
