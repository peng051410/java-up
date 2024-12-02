/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author tomyli
 * @date 2024/12/2
 * enjoy
 */
@Configuration
@Lazy
public class LazyConfiguration {

    // No Bean will pre-instantiated
}
