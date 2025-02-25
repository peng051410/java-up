/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@RunWith(SpringRunner.class)
// disable all default listener
@TestExecutionListeners()
public class SimpleTest {

    @Test
    public void testMethod() {
        
    }
}
