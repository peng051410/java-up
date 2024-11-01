/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

import net.bytebuddy.implementation.bind.annotation.Pipe;

import java.util.List;

/**
 * @author tomyli
 * @date 2024/10/25
 * enjoy
 */
public class ForwardingLoggerInterceptor {

    private final MemoryDatabase memoryDatabase;

    public ForwardingLoggerInterceptor(MemoryDatabase memoryDatabase) {
        this.memoryDatabase = memoryDatabase;
    }

    public List<String> log(@Pipe Forwarder<List<String>, MemoryDatabase> pipe) {
        System.out.println("Calling database with pipe");
        try {
            return pipe.to(memoryDatabase);
        } finally {
            System.out.println("Returned from database from pipe");
        }
    }
}
