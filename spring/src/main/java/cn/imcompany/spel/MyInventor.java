/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import lombok.Data;

import java.util.Date;

/**
 * @author tomyli
 * @date 2025/1/8
 * enjoy
 */
@Data
public class MyInventor {

    private String name;
    private int age;
    private Date birthDay;
    private String[] inventions;

    public MyInventor() {
    }

    public MyInventor(String name, Date date) {
        this.name = name;
        this.birthDay = date;
    }

    public void setInventions(String... inventions) {
        this.inventions = inventions;
    }
}
