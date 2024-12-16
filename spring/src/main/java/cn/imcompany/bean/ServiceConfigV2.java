/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author tomyli
 * @date 2024/12/13
 * enjoy
 */
@Configuration
public class ServiceConfigV2 {

    @Autowired
    private RepositoryConfigV2 repositoryConfigV2;

    @Bean
    public TransferService transferService() {
        return new TransferService(repositoryConfigV2.accountRepository());
    }
}
