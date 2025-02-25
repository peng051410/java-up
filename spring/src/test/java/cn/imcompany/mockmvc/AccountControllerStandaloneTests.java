/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.mockmvc;

import cn.imcompany.webmvc.MyController;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

/**
 * @author tomyli
 * @date 2025/2/25
 * enjoy
 */
@SpringJUnitConfig(locations = "my-servlet-context.xml")
public class AccountControllerStandaloneTests {

    private final MockMvcTester mockMvc = MockMvcTester.of(new MyController());
}
