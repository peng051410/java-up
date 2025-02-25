/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.junit;

import cn.imcompany.test.TestConfig;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Nested;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author tomyli
 * @date 2025/2/24
 * enjoy
 */
@RunWith(Enclosed.class)
@SpringJUnitConfig(TestConfig.class)
public class GreetingServiceTests {

    @Autowired GreetingService greetingService;

    @Nested
    @ActiveProfiles("lang_en")
    public class EnglishGreetings {

        @Test
        public void hello() {
            System.out.println(greetingService.greet());
        }
    }

    @Nested
    @ActiveProfiles("lang_de")
    public class GermanGreetings {

        @Test
        public void hello() {
            System.out.println(greetingService.greetWorld());
        }
    }
}
