/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author tomyli
 * @date 2025/1/2
 * enjoy
 */
public record Inventor(String name, Date birthDay, String nationality, List<String> inventions, Map<String, String> officers) {

    public Inventor(String name, Date birthDay) {
        this(name, birthDay, "Unknown", List.of(), Map.of());
    }

    public Inventor(String name, Date birthDay, String nationality) {
        this(name, birthDay, nationality, List.of(), Map.of());
    }

    public Inventor(String name, Date birthDay, List<String> inventions) {
        this(name, birthDay, "Unknown", inventions, Map.of());
    }

    public Inventor(String name, Date birth, String nationality, String... inventions) {
        this(name, birth, nationality, List.of(inventions), Map.of());
    }

    public Inventor(String name, Date birth, String nationality, List<String> inventions) {
        this(name, birth, nationality, inventions, Map.of());
    }


}
