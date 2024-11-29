/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

/**
 * @author tomyli
 * @date 2024/11/29
 * enjoy
 */
public class TargetBean {

    private ExampleBean exampleBean;

    public ExampleBean getExampleBean() {
        return exampleBean;
    }

    public TargetBean setExampleBean(ExampleBean exampleBean) {
        this.exampleBean = exampleBean;
        return this;
    }
}
