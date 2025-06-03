/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.importannotation;

import cn.imcompany.importannotation.bean.MyBean;
import org.springframework.context.annotation.Import;

/**
 *
 * @author tomyli
 * @date 2025/5/20
 * enjoy
 */
@Import(MyBean.class)
public class MyComponentConfig {
}
