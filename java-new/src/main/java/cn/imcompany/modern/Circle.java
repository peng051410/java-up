/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.modern;


/**
 * @author tomyli
 * @date 2024/2/4
 * enjoy
 */
public record Circle(double radius) implements Shape {

    public Circle {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

}
