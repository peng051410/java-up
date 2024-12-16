/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author tomyli
 * @date 2024/12/16
 * enjoy
 */
@Configuration
public class DefaultRepositoryConfig implements RepositoryConfigV2 {

    @Override
    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepository(new MyDataSource());
    }
}
