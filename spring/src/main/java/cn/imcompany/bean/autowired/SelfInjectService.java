/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tomyli
 * @date 2025/6/18
 * enjoy
 */
@Service
public class SelfInjectService {

    @Autowired
    private SelfInjectService selfInjectService;

    public void doSomething() {
        System.out.println("SelfInjectService is doing something.");
    }

    public void selfInject() {
        selfInjectService.doSomething();
    }

}
