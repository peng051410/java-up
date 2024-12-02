/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tomyli
 * @date 2024/12/2
 * enjoy
 */
@Component
public abstract class CommandManagerAnno {

    public Object process(Map commandState) {
        // grab a new instance of the appropriate Command
        CommandAnno command = createCommand();
        // set the state on the (hopefully brand new) Command instance
        command.setState(commandState);
        return command.execute();
    }

    @Lookup
    protected abstract CommandAnno createCommand();
}
