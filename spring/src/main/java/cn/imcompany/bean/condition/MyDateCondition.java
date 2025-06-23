/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.time.LocalDateTime;

/**
 * @author tomyli
 * @date 2025/6/16
 * enjoy
 */
public class MyDateCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        return minute % 2 == 0; // 每隔两分钟满足条件
    }
}
