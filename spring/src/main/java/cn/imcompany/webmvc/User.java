/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author tomyli
 * @date 2025/2/6
 * enjoy
 */
public class User {

    public interface WithoutPasswordView {
    }


    public interface WithPasswordView extends WithoutPasswordView {
    }

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return this.username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return this.password;
    }
}
