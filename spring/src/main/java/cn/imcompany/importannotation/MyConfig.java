/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.importannotation;

import cn.imcompany.importannotation.bean.MyBeanG;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author tomyli
 * @date 2025/5/20
 * enjoy
 */
@Configuration
@Import({MyConfig2.class, MyComponentConfig.class, MyImportSelector.class, MyDeferredImportSelector.class, MyImportBeanDefinitionRegistrar.class, MyBeanG.class})
public class MyConfig {
}
