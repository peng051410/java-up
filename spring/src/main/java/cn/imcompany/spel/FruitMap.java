/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tomyli
 * @date 2025/1/6
 * enjoy
 */
public class FruitMap {

    private final Map<Color, String> map = new HashMap<>();

    public FruitMap() {
        map.put(Color.RED, "apple");
        map.put(Color.GREEN, "pear");
        map.put(Color.BLUE, "blueberry");
    }

    public String getFruit(Color color) {
        return map.get(color);
    }

    public void setFruit(Color color, String fruit) {
        map.put(color, fruit);
    }
}
