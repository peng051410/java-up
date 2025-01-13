/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.example;

import lombok.Getter;

import java.lang.instrument.Instrumentation;

/**
 * @author tomyli
 * @date 2025/1/13
 * enjoy
 */
public class InstrumentationSavingAgent {

    @Getter
    private static volatile Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

}
