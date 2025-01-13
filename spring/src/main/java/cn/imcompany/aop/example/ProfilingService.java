/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.example;

import java.util.concurrent.TimeUnit;

/**
 * @author tomyli
 * @date 2025/1/13
 * enjoy
 */
public class ProfilingService {

    public void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("do something");
    }

    public void doSomethingElse() {
        System.out.println("do something else");
    }

    public void doSomething(int i) {
        System.out.println("do something " + i);
    }

    public void doSomething(String s) {
        System.out.println("do something " + s);
    }

    public void doSomething(int i, String s) {
        System.out.println("do something " + i + " " + s);
    }

    public void doSomething(String s, int i) {
        System.out.println("do something " + s + " " + i);
    }

    public void doSomethingElse(int i) {
        System.out.println("do something else " + i);
    }

    public void doSomethingElse(String s) {
        System.out.println("do something else " + s);
    }

    public void doSomethingElse(int i, String s) {
        System.out.println("do something else " + i + " " + s);
    }

    public void doSomethingElse(String s, int i) {
        System.out.println("do something else " + s + " " + i);
    }

    public void doSomething(int i, String s, int j) {
        System.out.println("do something " + i + " " + s + " " + j);
    }

    public void doSomething(String s, int i, String t) {
        System.out.println("do something " + s + " " + i + " " + t);
    }

    public void doSomethingElse(int i, String s, int j) {
        System.out.println("do something else " + i + " " + s + " " + j);
    }

    public void doSomethingElse(String s, int i, String t) {
        System.out.println("do something else " + s + " " + i + " " + t);
    }

    public void doSomething(int i, String s, int j, String t) {
        System.out.println("do something " + i + " " + s + " " + j + " " + t);
    }

}
