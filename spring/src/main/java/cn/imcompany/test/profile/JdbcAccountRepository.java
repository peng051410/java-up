/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

import javax.sql.DataSource;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
public class JdbcAccountRepository implements AccountRepository {

    private final DataSource dataSource;

    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
