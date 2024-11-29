/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import java.util.StringJoiner;

/**
 * @author tomyli
 * @date 2024/11/29
 * enjoy
 */
public class ExampleBean {

    // Number of years to calculate the Ultimate Answer
    private final int years;

    // The Answer to Life, the Universe, and Everything
    private final String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExampleBean.class.getSimpleName() + "[", "]")
                .add("years=" + years)
                .add("ultimateAnswer='" + ultimateAnswer + "'")
                .toString();
    }
}
