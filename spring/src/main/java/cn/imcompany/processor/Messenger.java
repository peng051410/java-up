/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.processor;

import org.springframework.stereotype.Component;

/**
 * @author tomyli
 * @date 2024/12/9
 * enjoy
 */
@Component
public class Messenger {

    public void send(String message) {
        System.out.println("send message: " + message);
    }
}
