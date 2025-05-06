/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.mockmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author tomyli
 * @date 2025/2/25
 * enjoy
 */
// @SpringJUnitConfig(ApplicationWebConfiguration.class)
public class AccountControllerIntegrationTests {

    private final MockMvcTester mockMvc;

    public AccountControllerIntegrationTests(@Autowired WebApplicationContext mockMvc) {
        this.mockMvc = MockMvcTester.from(mockMvc);
    }
}
