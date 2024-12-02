/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import java.util.Map;

/**
 * @author tomyli
 * @date 2024/12/2
 * enjoy
 */
public class SomeClass {
    private Map<String, Float> accounts;

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }

    public Map getAccounts() {
        return accounts;
    }
}
