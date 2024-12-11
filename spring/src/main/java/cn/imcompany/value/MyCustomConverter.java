/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.value;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

/**
 * @author tomyli
 * @date 2024/12/11
 * enjoy
 */
public class MyCustomConverter implements Converter<ValueDemo, String>, GenericConverter {
    @Override
    public String convert(ValueDemo source) {
        return source.getValue();
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Set.of();
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return null;
    }
}
