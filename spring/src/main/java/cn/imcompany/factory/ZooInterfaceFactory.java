/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class ZooInterfaceFactory {

    private final BarInterface barInterface = new BarInterfaceImpl();

    public BarInterface getInstance() {
        return barInterface;
    }
}
