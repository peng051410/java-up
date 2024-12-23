/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.wrapper;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

/**
 * @author tomyli
 * @date 2024/12/23
 * enjoy
 */
@Component
public class ExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new ExoticType(text.toUpperCase()));
    }
}
