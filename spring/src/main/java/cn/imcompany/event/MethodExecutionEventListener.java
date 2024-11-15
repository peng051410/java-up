/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author tomyli
 * @date 2024/11/15
 * enjoy
 */
@Service
public class MethodExecutionEventListener implements ApplicationListener<MethodExecutionEvent> {

    @Override
    public void onApplicationEvent(MethodExecutionEvent event) {
        System.out.println("event = " + event);
    }
}
