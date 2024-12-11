/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2024/12/11
 * enjoy
 */
@Component
public class MovieRecommender {

    @Value("${catalog.value:1123}")
    private String catalogValue;

    @Value("#{new cn.imcompany.value.ValueDemo().setValue('666')}")
    private String mycustom;

    private final String catalog;

    public MovieRecommender(@Value("${catalog.name}") String catalog) {
        this.catalog = catalog;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getMycustom() {
        return mycustom;
    }
}
