/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.scan;

import cn.imcompany.bean.scan.service.AdminService;
import cn.imcompany.bean.scan.special.SpecialComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author tomyli
 * @date 2025/5/6
 * enjoy
 */
@Configuration
@ComponentScan(
        basePackages = {"cn.imcompany.bean.scan"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SpecialComponent.class}),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {AdminService.class})
)
public class MyConfiguration {
}
