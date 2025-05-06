/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 *
 * @author tomyli
 * @date 2025/4/27
 * enjoy
 */
@Configuration
@PropertySource("classpath:/conf/app.properties")
@Import(DatabaseConfig.class)
public class MyConfig {

    @Value("${mybean.name:bean1}")
    private String name;

    @Autowired
    private Environment env;

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName(name);
        System.out.println(Arrays.toString(env.getActiveProfiles()));
        return myBean;
    }

    @Bean
    public MyBean2 myBean2() {
        MyBean2 myBean2 = new MyBean2();
        myBean2.setParentBean(myBean());
        return myBean2;
    }

    @Profile("dev")
    public DataSource embeddedDatabase() {
        return new EmbeddedDatabaseBuilder().setName("dev").build();
    }

    @Profile("prod")
    public DataSource prodDatabase() {
        return new EmbeddedDatabaseBuilder().setName("prod").build();
    }
}

