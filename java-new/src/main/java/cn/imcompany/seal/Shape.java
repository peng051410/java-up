/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.seal;

/**
 * @author tomyli
 * @date 2024/2/5
 * enjoy
 */
public abstract class Shape {

    public final String id;

    public Shape(String id) {
        this.id = id;
    }

    public abstract double area();
}
