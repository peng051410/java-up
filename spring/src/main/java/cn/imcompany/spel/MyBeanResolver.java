/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.spel;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

/**
 * @author tomyli
 * @date 2025/1/8
 * enjoy
 */
public class MyBeanResolver implements BeanResolver {
    
    @Override
    public Object resolve(EvaluationContext context, String beanName) throws AccessException {
        System.out.println(beanName);
        if ("inventor".equals(beanName)) {
            return new MyInventor("tomyli", null);
        }
        return null;
    }
}
