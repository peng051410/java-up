/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/12
 * enjoy
 */
// will load ExtendedConfig and BaseConfig
@SpringJUnitConfig(ExtendedConfig.class)
public class ExtendedTest extends BaseTest {
}
