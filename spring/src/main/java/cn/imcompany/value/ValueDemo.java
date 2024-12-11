/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.value;

/**
 * @author tomyli
 * @date 2024/12/11
 * enjoy
 */
public class ValueDemo {

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public ValueDemo setValue(String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public ValueDemo setName(String name) {
        this.name = name;
        return this;
    }
}
