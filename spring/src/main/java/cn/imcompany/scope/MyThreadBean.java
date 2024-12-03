/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2024/12/3
 * enjoy
 */
@Component
@Scope("myScope")
public class MyThreadBean {

    public void doSomething() {
        System.out.println("MyThreadBean " + this);
    }
}
