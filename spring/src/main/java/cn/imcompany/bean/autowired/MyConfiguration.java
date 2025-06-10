/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author tomyli
 * @date 2025/6/5
 * enjoy
 */
@Configuration
@ComponentScan(basePackages = "cn.imcompany.bean.autowired")
@PropertySource("classpath:application.properties")
public class MyConfiguration {

}
