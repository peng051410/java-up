/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tomyli
 * @date 2024/12/11
 * enjoy
 */
@Component
public class MovieRecommenderV2 {


    @Value("#{{'Thriller': 100, 'Comedy': 200, 'Action': 300}}")
    private Map<String, Integer> genreMap;

    private final String catalog;

    public MovieRecommenderV2(@Value("#{systemProperties['user.catalog'] + '.catalog'}") String catalog) {
        this.catalog = catalog;
    }

    public String getCatalog() {
        return catalog;
    }

    public Map<String, Integer> getGenreMap() {
        return genreMap;
    }

}
