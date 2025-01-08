/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import cn.imcompany.spel.inventor.InventorV2;
import cn.imcompany.spel.inventor.PlaceOfBirth;
import cn.imcompany.spel.inventor.Society;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.IndexAccessor;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectiveIndexAccessor;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.Date;
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

    @Test
    public void testSpelOperator() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Object value = parser.parseExpression("1 + 2").getValue();
        assertEquals(3, value);

        Object value1 = parser.parseExpression("1 < -5.0").getValue();
        assertEquals(false, value1);

        Object value2 = parser.parseExpression("'black' < 'block'").getValue();
        assertEquals(true, value2);

        Object value3 = parser.parseExpression("'xyz' instanceof T(Integer)").getValue();
        assertEquals(false, value3);

        // 对类的引用要用全限定名
        boolean trueValue = Boolean.TRUE.equals(parser.parseExpression("new cn.imcompany.spel.CustomValue(1) < new cn.imcompany.spel.CustomValue(2)"
        ).getValue(Boolean.class));
        assertEquals(true, trueValue);

        Boolean value4 = parser.parseExpression("1 between {1, 5}").getValue(Boolean.class);
        assertEquals(true, value4);

        Boolean value5 = parser.parseExpression("'elephant' between {'ant', 'hippo'}").getValue(Boolean.class);
        assertEquals(true, value5);

        Boolean value6 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class);
        assertEquals(true, value6);

        Boolean trueAndFalse = parser.parseExpression("true and false").getValue(Boolean.class);
        assertEquals(false, trueAndFalse);

        Boolean trueOrFalse = parser.parseExpression("true or false").getValue(Boolean.class);
        assertEquals(true, trueOrFalse);

        String value7 = parser.parseExpression("'hello' + '' + 'world'").getValue(String.class);
        assertEquals("helloworld", value7);

        Character value8 = parser.parseExpression("'d' - 3").getValue(char.class);
        assertEquals('a', value8);

        String value9 = parser.parseExpression("'abc' * 2").getValue(String.class);
        assertEquals("abcabc", value9);

        Integer value10 = parser.parseExpression("1 + 1").getValue(int.class);
        assertEquals(2, value10);

        MyInt myInt = new MyInt();
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        Integer value11 = parser.parseExpression("counter++ + 2").getValue(context, myInt, int.class);
        // counter is now 1
        assertEquals(2, value11);

        Integer value12 = parser.parseExpression("++counter + 2").getValue(context, myInt, int.class);
        // counter is now 2
        assertEquals(4, value12);
    }

    @Test
    public void testSpelSet() {
        MyInt myInt = new MyInt();
        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        parser.parseExpression("name").setValue(context, myInt, "Tony");
        assertEquals("Tony", myInt.getName());

        String value = parser.parseExpression("name = 'alaaaa'").getValue(context, myInt, String.class);
        assertEquals("alaaaa", value);
    }

    @Test
    public void testSpelOverloadOperator() {

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setOperatorOverloader(new ListConcatenation());

        SpelExpressionParser parser = new SpelExpressionParser();
        List value = parser.parseExpression("{1, 2, 3} + {4, 5, 6}").getValue(context, List.class);
        System.out.println(value);
        assertEquals(6, value.size());
    }

    @Test
    public void testSpelTypes() {
        //The StandardEvaluationContext uses a TypeLocator to find types, and the StandardTypeLocator (which can be replaced) is built with an
        // understanding of the java.lang package.
        SpelExpressionParser parser = new SpelExpressionParser();
        Class value = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        assertEquals(Date.class, value);

        Class value1 = parser.parseExpression("T(String)").getValue(Class.class);
        assertEquals(String.class, value1);

        Boolean value2 = parser.parseExpression(("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")).getValue(Boolean.class);
        assertEquals(true, value2);

    }

    @Test
    public void testSpelConstructors() {

        SpelExpressionParser parser = new SpelExpressionParser();
        Inventor value = parser.parseExpression("new cn.imcompany.spel.Inventor('Nikola Tesla', new java.util.Date())").getValue(Inventor.class);
        assertNotNull(value);
    }

    @Test
    public void testSpelVariable() {

        MyInventor tesla = new MyInventor("Nikola Tesla", new Date());

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        context.setVariable("newName", "Mike Tesla");
        String value = parser.parseExpression("name = #newName").getValue(context, tesla, String.class);
        assertEquals("Mike Tesla", value);
        String name = tesla.getName();
        assertEquals("Mike Tesla", name);
    }

    @Test
    public void testSeplVarThis() {

        List<Integer> prims = List.of(2, 3, 5, 7, 11, 13, 17);

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("primes", prims);

        // select all prime numbers > 10
        String expression = "#primes.?[#this>10]";

        List<Integer> value = parser.parseExpression(expression).getValue(context, List.class);
        assertEquals(List.of(11, 13, 17), value);
        assertEquals(3, value.size());
    }

    @Test
    public void testSpelThisAndRoot() {

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        MyInventor tesla = new MyInventor("Nikola Tesla", new Date());
        tesla.setInventions("Telephone repeater", "Tesla coil transformer", "Induction motor");

        // 表达式是变的，可以进行动态的拼接
        String expression = "#root.inventions.![#root.name + ' invented ' + #this + '.']";

        List value = parser.parseExpression(expression).getValue(context, tesla, List.class);
        assertEquals(List.of("Nikola Tesla invented Telephone repeater.", "Nikola Tesla invented Tesla coil transformer.", "Nikola Tesla invented " +
                "Induction motor."), value);
        assertEquals(3, value.size());
    }

    @Test
    public void testSeplFunction() throws NoSuchMethodException {

        SpelExpressionParser parser = new SpelExpressionParser();

        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("hasText", StringUtils.class.getMethod("hasText", String.class));

        Boolean value = parser.parseExpression("#hasText('hello')").getValue(context, Boolean.class);
        assertEquals(true, value);
    }

    @Test
    public void testSpelMethodHandle() throws NoSuchMethodException, IllegalAccessException {

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        MethodHandle mh = MethodHandles.lookup().findVirtual(String.class, "formatted", MethodType.methodType(String.class, Object[].class));
        context.setVariable("message", mh);

        String value = parser.parseExpression("#message('Simple message: <%s>', 'Hello World', 'ignored')").getValue(context, String.class);
        assertEquals("Simple message: <Hello World>", value);
    }

    @Test
    public void testSpelFunctionParam() throws NoSuchMethodException, IllegalAccessException {

        SpelExpressionParser parser = new SpelExpressionParser();
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        String template = "This is a %s message with %s words: <%s>";
        Object varargs = new Object[]{"prerecorded", 3, "Oh Hello World", "ignored"};

        MethodHandle mh = MethodHandles.lookup().findVirtual(String.class, "formatted", MethodType.methodType(String.class, Object[].class))
                .bindTo(template)
                .bindTo(varargs);
        context.setVariable("message", mh);

        String value = parser.parseExpression("#message()").getValue(context, String.class);
        assertEquals("This is a prerecorded message with 3 words: <Oh Hello World>", value);
    }

    @Test
    public void testSpelVarargs() throws NoSuchMethodException {

        SpelExpressionParser parser = new SpelExpressionParser();
        String expression = "'%s is color #%d'.formatted('Blue', 2)";
        String value = parser.parseExpression(expression).getValue(String.class);
        assertEquals("Blue is color #2", value);

        String expression1 = "'%s is color #%d'.formatted(new Object[] {'Blue', 2})";
        String value1 = parser.parseExpression(expression1).getValue(String.class);
        assertEquals("Blue is color #2", value1);

        String expression2 = "'%s is color #%d'.formatted({'Blue', 2})";
        String value2 = parser.parseExpression(expression2).getValue(String.class);
        assertEquals("Blue is color #2", value2);

        // type conversion test
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        context.setVariable("sortStringArray", StringUtils.class.getMethod("sortStringArray", String[].class));
        String expression3 = "#sortStringArray({'c', '3.0', '11'})";
        String[] value3 = parser.parseExpression(expression3).getValue(context, String[].class);
        Arrays.stream(value3).forEach(System.out::println);
        assertEquals(3, value3.length);
    }

    @Test
    public void testSpelBeanRef() {

        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new MyBeanResolver());

        Object value = parser.parseExpression("@inventor").getValue(context);
        assertNotNull(value);

        // 通过&符号获取工厂bean
        Object factoryBean = parser.parseExpression("&someFactoryBean").getValue(context);
        assertNull(factoryBean);
    }

    @Test
    public void testSpelIfElse() {

        SpelExpressionParser parser = new SpelExpressionParser();
        String value = parser.parseExpression("true ? 'a' : 'b'").getValue(String.class);
        assertEquals("a", value);

        // @Value("#{systemProperties['pop3.port'] ?: 25}")
        String name = parser.parseExpression("name?:'Unknown'").getValue(new MyInventor(), String.class);
        assertEquals("Unknown", name);
    }

    @Test
    public void testSafeNav() {

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        InventorV2 tesla = new InventorV2("Nikola Tesla", "Serbian");
        tesla.setPlaceOfBirth(new PlaceOfBirth("Smiljan"));

        String city = parser.parseExpression("placeOfBirth?.city")
                .getValue(context, tesla, String.class);
        assertEquals("Smiljan", city);

        tesla.setPlaceOfBirth(null);

        city = parser.parseExpression("placeOfBirth?.city")
                .getValue(context, tesla, String.class);
        assertNull(city);
    }

    @Test
    public void testSpelSafeIndex() {

        ExpressionParser parser = new SpelExpressionParser();
        Society society = new Society();
        EvaluationContext context = new StandardEvaluationContext(society);

        // if the collection is empty, invoke index accessor will throw an exception
//         InventorV2 inventor = parser.parseExpression("members?.[0]")
//                 .getValue(context, InventorV2.class);
//         assertNull(inventor);

        society.setMembers(null);

// evaluates to null - does not throw an exception
        InventorV2 inventor = parser.parseExpression("members?.[0]")
                .getValue(context, InventorV2.class);
        assertNull(inventor);
    }
}
