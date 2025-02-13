/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
@ActiveProfiles(resolver = OperatingSystemActiveProfilesResolver.class, inheritProfiles = false)
public class TransferServiceWithProfileResolverTest extends AbstractIntegrationTest {

    // @Autowired
    private TransferService transferService;

    @Test
    void testTransfer() {
    }
}
