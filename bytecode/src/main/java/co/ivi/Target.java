/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

/**
 * @author tomyli
 * @date 2024/10/24
 * enjoy
 */
public class Target {
    // public static String hello(String name) {
    //     return "Hello " + name + "!";
    // }

    public static String intercept(String name) {
        return "Hello " + name + "!";
    }

    public static String intercept(int i) {
        return Integer.toString(i);
    }

    public static String intercept(Object o) {
        return o.toString();
    }
}
