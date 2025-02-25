/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import org.junit.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@SpringJUnitWebConfig(TestWebConfig.class)
public class SimpleWebTests {

    @Test
    public void testMethod() {

    }
}
