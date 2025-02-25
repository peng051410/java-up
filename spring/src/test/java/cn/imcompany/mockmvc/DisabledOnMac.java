/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.mockmvc;

import org.springframework.test.context.junit.jupiter.DisabledIf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tomyli
 * @date 2025/2/25
 * enjoy
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DisabledIf(
        expression = "#{systemProperties['os.name'].toLowerCase().contains('mac')}",
        reason = "Disabled on Mac OS"
)
public @interface DisabledOnMac {
}
