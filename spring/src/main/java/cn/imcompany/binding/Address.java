/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.binding;

/**
 * @author tomyli
 * @date 2024/12/20
 * enjoy
 */
public class Address {

    private String name;
    private String street;

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
}
