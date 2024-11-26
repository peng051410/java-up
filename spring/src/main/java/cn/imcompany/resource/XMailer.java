/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.resource;

import org.springframework.core.io.Resource;

/**
 * @author tomyli
 * @date 2024/11/26
 * enjoy
 */
public class XMailer {

    private Resource template;

    public void sendMail() {
        System.out.println(template.getClass());
    }

    public Resource getTemplate() {
        return template;
    }

    public XMailer setTemplate(Resource template) {
        this.template = template;
        return this;
    }
}
