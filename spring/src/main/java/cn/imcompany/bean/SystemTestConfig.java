/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 *
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {

    @Bean
    public MyDataSource myDataSource() {
        return new MyDataSource();
    }
}
