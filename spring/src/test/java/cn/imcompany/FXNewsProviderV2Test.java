/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author tomyli
 * @date 2024/10/30
 * enjoy
 */
class FXNewsProviderV2Test {

    private FXNewsProviderV2 fxNewsProviderV2;

    @BeforeEach
    public void setUp() {
        fxNewsProviderV2 = new FXNewsProviderV2(new MockNewsListener(), new DowJonesNewsPersisterV2());
    }

    @Test
    public void testOne() {
        fxNewsProviderV2.getAndPersistNews();
    }
}
