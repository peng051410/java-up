/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany;

/**
 * @author tomyli
 * @date 2024/10/30
 * enjoy
 */
public class MockNewsListener implements IFXNewsListener {
    @Override
    public void doJob() {

        System.out.println("MockNewsListener");
    }
}
