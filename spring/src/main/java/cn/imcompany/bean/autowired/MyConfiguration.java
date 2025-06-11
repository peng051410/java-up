/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

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

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
        customEditors.put(StudentValue.class, StudentValueEditor.class);
        configurer.setCustomEditors(customEditors);
        return configurer;
    }
}
