/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.listener;

import org.springframework.context.event.EventListener;

/**
 * @author tomyli
 * @date 2024/12/19
 * enjoy
 */
public class EntityNotifier {

    @EventListener
    public void notify(EntityCreatedEvent<Person> event) {
        // notify appropriate parties
    }
}
