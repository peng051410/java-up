/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import lombok.Data;

/**
 * @author tomyli
 * @date 2025/1/7
 * enjoy
 */
@Data
public class CustomValue implements Comparable<CustomValue> {

    public Integer value;

    public CustomValue(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(CustomValue o) {
        return Integer.compare(this.value, o.value);
    }
}
