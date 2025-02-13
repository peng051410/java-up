/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.property;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
@ContextConfiguration
// test.properties defined port value wil override by properties port value
@TestPropertySource(
        locations = "classpath:/test.properties",
        properties = """
                timezone = GMT+8
                port = 4242
                """)
public class MyIntegrationTests5 {
}
