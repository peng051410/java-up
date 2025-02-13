/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
@SpringJUnitConfig({
        TransferServiceConfig.class,
        StandaloneDataConfig.class,
        JndiDataConfig.class,
        DefaultDataConfig.class
})
@ActiveProfiles("dev")
public abstract class AbstractIntegrationTest {
}
