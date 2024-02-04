/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany;

import cn.imcompany.modern.Circle;

/**
 * @author tomyli
 * @date 2024/2/2
 * enjoy
 */
public class APP {

    public static void main(String[] args) {
        String textBlock = """
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>"Hello World!"</h1>
                    </body>
                </html>
                """;
        System.out.println(textBlock.length());

        // There are 8 leading white spaces in common
        String textBlock2 = """
                ........<!DOCTYPE html>    \s!!!!
                ........<html>             \s
                ........    <body>!!!!!!!!!!
                ........        <h1>"Hello World!"</h1>
                ........    </body>
                ........</html>
                ........""";
        System.out.println(textBlock2);
        System.out.println(textBlock2.length());

        String poem = """
                     No man is an island,
                       Entire of itself,
                Every man is a piece of the continent,
                      A part of the main.
                """;
        System.out.println(poem);

        Circle circle = new Circle(3);
        System.out.println(circle.radius());

        Circle c1 = new Circle(10.0);
        Circle c2 = new Circle(10.0);
        System.out.println(c1.equals(c2));
    }


}
