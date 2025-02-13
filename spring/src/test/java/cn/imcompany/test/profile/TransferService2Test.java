/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.test.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tomyli
 * @date 2025/2/13
 * enjoy
 */
//profile inherited from super class
public class TransferService2Test extends AbstractIntegrationTest {

    @Autowired
    TransferService transferService;

    @Test
    void testTransfer() {
    }
}
