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
public class Square extends Shape {
    public final double side;

    public Square(String id, double side) {
        super(id);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
