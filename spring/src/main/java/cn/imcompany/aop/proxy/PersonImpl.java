/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.aop.proxy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tomyli
 * @date 2025/1/16
 * enjoy
 */
@Setter
@Getter
public class PersonImpl {
    private String name;
    private String age;

    public void sayHello() {
        System.out.println("hello, my name is " + name + ", I am " + age + " years old.");
    }
}
