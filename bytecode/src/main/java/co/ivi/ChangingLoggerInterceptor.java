/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

/**
 * @author tomyli
 * @date 2024/10/25
 * enjoy
 */
public class ChangingLoggerInterceptor {

    public static List<String> log(String info, @Super MemoryDatabase zuper) {
        System.out.println("Calling database");
        try {
            return zuper.load(info + "(logged access");
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println("Returned from database");
        }
        return List.of();
    }
}
