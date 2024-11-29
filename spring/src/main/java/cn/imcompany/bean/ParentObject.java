/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean;

import java.util.Properties;

/**
 * @author tomyli
 * @date 2024/11/29
 * enjoy
 */
public class ParentObject {

    private Properties adminEmails;

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public Properties getAdminEmails() {
        return adminEmails;
    }
}
