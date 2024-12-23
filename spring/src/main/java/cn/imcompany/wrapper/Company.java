/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.wrapper;

/**
 * @author tomyli
 * @date 2024/12/23
 * enjoy
 */
public class Company {

    private String name;
    private Employee managingDirector;

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Employee getManagingDirector() {
        return managingDirector;
    }

    public Company setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
        return this;
    }
}
