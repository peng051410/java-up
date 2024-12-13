/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
@Configuration
public class RepositoryConfig {

    @Bean
    public AccountRepository accountRepository(MyDataSource myDataSource) {
        return new AccountRepository(myDataSource);
    }
}
