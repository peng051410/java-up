/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi;

import java.util.Arrays;
import java.util.List;

/**
 * @author tomyli
 * @date 2024/10/25
 * enjoy
 */
public class MemoryDatabase {

    public List<String> load(String info) {
        return Arrays.asList(info + "foo", info + "bar");
    }
}
