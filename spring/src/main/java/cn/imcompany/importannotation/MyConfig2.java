/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.importannotation;

import cn.imcompany.importannotation.bean.MyBeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tomyli
 * @date 2025/5/20
 * enjoy
 */
@Configuration
public class MyConfig2 {

    @Bean
    public MyBeanD myBeanD() {
        return new MyBeanD();
    }
}
