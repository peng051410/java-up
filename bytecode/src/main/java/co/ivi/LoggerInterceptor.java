/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author tomyli
 * @date 2024/10/25
 * enjoy
 */
public class LoggerInterceptor {

    public static List<String> log(@SuperCall Callable<List<String>> zuper) {
        System.out.println("Calling database");
        List<String> result = null;
        try {
            result = zuper.call();
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println("Returned from database");
        }
        return result;
    }
}
