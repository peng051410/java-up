/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.factory;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDate;

/**
 * @author tomyli
 * @date 2024/11/20
 * enjoy
 */
public class NextDayFactoryBean implements FactoryBean<LocalDate> {

    @Override
    public LocalDate getObject() throws Exception {
        return LocalDate.now().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return LocalDate.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
