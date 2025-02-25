/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import cn.imcompany.test.TestConfig;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class SimpleJupiterTests {

    @Test
    public void testMethod() {

    }
}
