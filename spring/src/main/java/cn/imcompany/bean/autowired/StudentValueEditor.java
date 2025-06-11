/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import java.beans.PropertyEditorSupport;

/**
 * @author tomyli
 * @date 2025/6/11
 * enjoy
 */
public class StudentValueEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        StudentValue studentValue = new StudentValue();
        studentValue.setName(text);
        setValue(studentValue);
    }
}
