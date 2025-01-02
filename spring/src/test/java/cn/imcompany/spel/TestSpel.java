/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author tomyli
 * @date 2025/1/2
 * enjoy
 */
public class TestSpel {

    @Test
    public void testSpel() {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world')");
        String message = (String) exp.getValue();
        assertEquals("hello world", message);
    }

    @Test
    public void testInvokeProperty() {

        ExpressionParser parser = new SpelExpressionParser();
        // invoke getBytes() method
        Expression exp = parser.parseExpression("'hello world'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        assertNotNull(bytes);
        assertEquals("hello world", new String(bytes));
    }

    @Test
    public void testInvokePropertyNested() {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'hello world'.bytes.length");
        int length = (int) exp.getValue();
        assertEquals(11, length);

        Expression exp1 = parser.parseExpression("new String('hello world').toUpperCase()");
        String value = exp1.getValue(String.class);
        assertEquals("HELLO WORLD", value);
    }

    @Test
    public void testInvokeInstance() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) exp.getValue(tesla);
        assertEquals("Nikola Tesla", name);

        exp = parser.parseExpression("name == 'Nikola Tesla'");
        assertEquals(Boolean.TRUE, exp.getValue(tesla, Boolean.class));
    }
}
