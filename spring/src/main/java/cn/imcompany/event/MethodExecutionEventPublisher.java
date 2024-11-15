/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author tomyli
 * @date 2024/11/15
 * enjoy
 */
@Service
public class MethodExecutionEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void methodToMonitor() {
        MethodExecutionEvent event = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        applicationEventPublisher.publishEvent(event);

        System.out.println("do biz");

        event = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.END);
        applicationEventPublisher.publishEvent(event);
    }
}
