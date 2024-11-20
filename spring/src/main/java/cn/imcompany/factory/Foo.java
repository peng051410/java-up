/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;


/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class Foo {

    private BarInterface barInterface;
    private BarInterface zooInterface;

    public Foo() {
    }

    public Foo setBarInterface(BarInterface barInterface) {
        this.barInterface = barInterface;
        return this;
    }

    public Foo setZooInterface(BarInterface zooInterface) {
        this.zooInterface = zooInterface;
        return this;
    }


    public void say() {
        System.out.println("hello bar:" + barInterface);
    }

    public void sayZoo() {
        System.out.println("hello zoo:" + zooInterface);
    }
}
