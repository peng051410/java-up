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
public class Employee {

    private String name;
    private float salary;

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public float getSalary() {
        return salary;
    }

    public Employee setSalary(float salary) {
        this.salary = salary;
        return this;
    }
}
