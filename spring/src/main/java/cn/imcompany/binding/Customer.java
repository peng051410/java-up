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
public class Customer {

    private String fisrtName;
    private String surName;
    private Address address;

    public String getFisrtName() {
        return fisrtName;
    }

    public Customer setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public Customer setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }
}
