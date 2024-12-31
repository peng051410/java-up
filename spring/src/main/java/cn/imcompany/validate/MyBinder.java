/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.validate;


import org.springframework.validation.DataBinder;

/**
 * @author tomyli
 * @date 2024/12/31
 * enjoy
 */
public class MyBinder {

    public static void main(String[] args) {
        Foo target = new Foo();
        target.setName("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");

        DataBinder binder = new DataBinder(target);
        binder.setValidator(new MyValidator());

        binder.validate();

        System.out.println(binder.getBindingResult());
    }
}
