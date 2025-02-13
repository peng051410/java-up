/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

import org.springframework.test.context.ActiveProfilesResolver;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
public class OperatingSystemActiveProfilesResolver implements ActiveProfilesResolver {

    @Override
    public String[] resolve(Class<?> testClass) {
        return new String[0];
    }
}
