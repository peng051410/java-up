/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.IndexAccessor;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectiveIndexAccessor;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertEquals(100, bean.getInitialShapeSeed());
    }

    @Test
    public void testSpelLiteral() {

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        assertEquals("Hello World", message);

        Object value = parser.parseExpression("'Tony''s message'").getValue();
        assertEquals("Tony's message", value);

        Object value1 = parser.parseExpression("6.0221415E+23").getValue();
        assertEquals(6.0221415E+23, value1);

        Object value2 = parser.parseExpression("0x7FFFFFFF").getValue();
        assertEquals(2147483647, value2);

        Object value3 = parser.parseExpression("true").getValue();
        assertEquals(true, value3);

        Object value4 = parser.parseExpression("null").getValue();
        assertNull(value4);
    }

    @Test
    public void testInvokeInstance2() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();

        Object value = parser.parseExpression("birthDay.year + 1900").getValue(tesla);
        assertEquals(1856, value);

        // cas insensitive
        Object value2 = parser.parseExpression("birthDay.Year + 1900").getValue(tesla);
        assertEquals(1856, value2);

    }

    @Test
    public void testSpelList() {

        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        List<String> inventions = List.of("Nikola Tesla", "Nikola Tesla1", "Nikola Tesla2", "Nikola Tesla3");
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian", inventions);

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        // If the indexed collection is a java.util.List, the nth element will be accessed
        // directly via list.get(n).
        String invention = parser.parseExpression("inventions[3]").getValue(context, tesla, String.class);
        assertEquals("Nikola Tesla3", invention);


        String character = parser.parseExpression("name[7]")
                .getValue(context, tesla, String.class);
        assertEquals("T", character);
    }

    @Test
    public void testSpelMap() {

        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        List<String> inventions = List.of("Nikola Tesla", "Nikola Tesla1", "Nikola Tesla2", "Nikola Tesla3");
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian", inventions,
                Map.of("president", "officer1", "normal", "officer2"));

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        // If the indexed collection is a java.util.List, the nth element will be accessed
        // directly via list.get(n).
        String office = parser.parseExpression("officers[president]").getValue(context, tesla, String.class);
        assertEquals("officer1", office);

    }

    @Test
    public void testSpelObject() {

        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        List<String> inventions = List.of("Nikola Tesla", "Nikola Tesla1", "Nikola Tesla2", "Nikola Tesla3");
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian", inventions,
                Map.of("president", "officer1", "normal", "officer2"));

        SpelExpressionParser parser = new SpelExpressionParser();
        Object value = parser.parseExpression("#root['name']").getValue(tesla);
        assertEquals("Nikola Tesla", value);
    }


    @Test
    public void testSeplAccessor() {

        IndexAccessor fruitMapAccessor = new ReflectiveIndexAccessor(FruitMap.class, Color.class, "getFruit", "setFruit");

        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        context.addIndexAccessor(fruitMapAccessor);
        context.setVariable("fruitMap", new FruitMap());

        String value = parser.parseExpression("#fruitMap[T(cn.imcompany.spel.Color).RED]").getValue(context, String.class);
        assertEquals("apple", value);

    }

    @Test
    public void testInlineList() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("{1, 2, 3, 4}");
        List<Integer> list = (List<Integer>) expression.getValue();
        assertEquals(4, list.size());

        List value = (List) parser.parseExpression("{{'a', 'b'}, {'x', 'y'}}").getValue();
        assertEquals(2, value.size());
    }

    @Test
    public void testInlineMap() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("{name:'Nikola', dob:'10-July-1856'}");
        Map<String, Object> map = (Map<String, Object>) expression.getValue();
        assertEquals(2, map.size());
    }

    @Test
    public void testSpelArrayConstruct() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("new int[4]");
        int[] array = (int[]) expression.getValue();
        assertEquals(4, array.length);

        Expression expression1 = parser.parseExpression("new int[]{1, 2, 3, 4}");
        int[] array1 = (int[]) expression1.getValue();
        assertEquals(4, array1.length);

        Object value = parser.parseExpression("new int[4][5]").getValue();
        assertEquals(4, ((int[][]) value).length);
    }

    @Test
    public void testSpelMethod() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("T(java.lang.Math).random()");
        double value = (double) expression.getValue();
        System.out.println(value);

        Object value1 = parser.parseExpression("'abc'.substring(1, 3)").getValue();
        assertEquals("bc", value1);
    }
}
