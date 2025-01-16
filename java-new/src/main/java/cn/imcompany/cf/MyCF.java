/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author tomyli
 * @date 2025/1/15
 * enjoy
 */
public class MyCF {

    public static void main(String[] args) throws InterruptedException {
        // new MyCF().world().thenAccept(System.out::println);
        new MyCF().world2().thenAccept(System.out::println);
        System.out.println(MyCF.class.getName());
    }

    public CompletableFuture<String> hello() throws InterruptedException {
        Thread.sleep(2000);
        return CompletableFuture.completedFuture("Hello, CompletableFuture!");
    }

    public CompletableFuture<String> helloWithTimeout() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Hello, CompletableFuture!";
                })
                // .orTimeout(1, TimeUnit.SECONDS)
                .completeOnTimeout("null", 1, TimeUnit.SECONDS);
    }

    public CompletableFuture<String> world() throws InterruptedException {
        long x = System.currentTimeMillis();
        System.out.println(x);
        String join = hello().join();
        System.out.println(System.currentTimeMillis() - x);
        return CompletableFuture.completedFuture(join + " World!");
    }

    public CompletableFuture<String> world2() throws InterruptedException {
        long x = System.currentTimeMillis();
        System.out.println(x);
        CompletableFuture<String> stringCompletableFuture = helloWithTimeout();
        stringCompletableFuture.completeOnTimeout("null", 1, TimeUnit.SECONDS);
        String join = stringCompletableFuture.join();
        System.out.println(System.currentTimeMillis() - x);
        return CompletableFuture.completedFuture(join + " World!");
    }
}
