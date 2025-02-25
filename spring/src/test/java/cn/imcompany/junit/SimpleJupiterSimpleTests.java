/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import cn.imcompany.test.TestConfig;
import org.junit.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@SpringJUnitConfig(TestConfig.class)
public class SimpleJupiterSimpleTests {

    @Test
    public void testMethod() {

    }
}
