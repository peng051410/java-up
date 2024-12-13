/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

/**
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
public class AccountRepository {
    private final MyDataSource myDataSource;

    public AccountRepository(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public void print() {
        System.out.println("AccountRepository:" + myDataSource);
    }
}
