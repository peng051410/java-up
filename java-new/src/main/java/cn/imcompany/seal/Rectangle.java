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
public class Rectangle extends Shape {
    public final double length;
    public final double width;

    public Rectangle(String id, double length, double width) {
        super(id);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
