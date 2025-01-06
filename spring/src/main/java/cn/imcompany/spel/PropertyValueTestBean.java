/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2025/1/6
 * enjoy
 */
@Component
public class PropertyValueTestBean {

    private String defaultLocale;

    public String getDefaultLocale() {
        return defaultLocale;
    }

    @Value("#{systemProperties['user.region']}")
    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }
}
