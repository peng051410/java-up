/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.bean;

import org.springframework.stereotype.Service;

import java.io.Closeable;

/**
 * @author tomyli
 * @date 2025/5/16
 * enjoy
 */
@Service
public class LightService implements Closeable {

    @Override
    public void close() {
        System.out.println("LightService.close");
    }
}
