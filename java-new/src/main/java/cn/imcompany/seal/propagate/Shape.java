/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.seal.propagate;

/**
 * @author tomyli
 * @date 2024/2/5
 * enjoy
 */
public abstract sealed class Shape {
    public final String id;

    protected Shape(String id) {
        this.id = id;
    }

    public abstract double area();

    public static non-sealed class Circle extends Shape {
        public final double radius;

        public Circle(String id, double radius) {
            super(id);
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static sealed class Square extends Shape {
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

    public static final class ColoredSquare extends Square {
        public final String color;

        public ColoredSquare(String id, double side, String color) {
            super(id, side);
            this.color = color;
        }
    }

    public static class ColoredCircle extends Circle {
        public final String color;

        public ColoredCircle(String id, double radius, String color) {
            super(id, radius);
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Shape shape = new ColoredSquare("1", 2, "red");
        System.out.println(shape.area());
    }

    public boolean isSquare(Shape shape) {

        if (shape instanceof Square rect) {
            return (rect.side == rect.side);
        }

        return false;
    }
    public boolean isSquare2(Shape shape) {

        if (!(shape instanceof Square rect)) {
            return false;
        }
        return (rect.side == rect.side);

    }
}
