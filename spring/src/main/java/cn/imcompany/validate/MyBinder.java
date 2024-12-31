/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.validate;


import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

/**
 * @author tomyli
 * @date 2024/12/31
 * enjoy
 */
public class MyBinder {

    public static void main(String[] args) {
        Foo target = new Foo();

        DataBinder binder = new DataBinder(target);
        binder.setValidator(new MyValidator());

        binder.bind(new MutablePropertyValues());

        binder.validate();

        System.out.println(binder.getBindingResult());
    }
}
