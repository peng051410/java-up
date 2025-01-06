/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

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

    @Test
    public void testEvaluationContext() {

        Simple simple = new Simple();
        simple.booleanList.add(true);

        ExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        // "false" is passed in here as a String. SpEL and the conversion service
        // will recognize that it needs to be a Boolean and convert it accordingly.
        parser.parseExpression("booleanList[0]").setValue(context, simple, false);

        assertEquals(false, simple.booleanList.get(0));
    }

    @Test
    public void testSpelConfigure() {

        SpelParserConfiguration config = new SpelParserConfiguration(true, true);
        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);

        System.out.println(o);
        assertEquals(4, demo.list.size());
    }

    @Test
    public void testConfigParam() {

        // spring.expression.compiler.mode
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass().getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(config);

        Expression expr = parser.parseExpression("payload");

        MyMessage myMessage = new MyMessage();

        Object payload = expr.getValue(myMessage);
    }

    @Test
    public void testSpelInBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.spel");
        ShapeGuess bean = context.getBean(ShapeGuess.class);
        Assertions.assertEquals(100, bean.getInitialShapeSeed());
    }
}
