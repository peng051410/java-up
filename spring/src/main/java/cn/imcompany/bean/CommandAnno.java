/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tomyli
 * @date 2024/12/2
 * enjoy
 */
@Component
@Scope("prototype")
public class CommandAnno {

    private Map commandState;

    public void setState(Map commandState) {
        this.commandState = commandState;
    }

    public Object execute() {
        System.out.println(this);
        return "execute";
    }
}
