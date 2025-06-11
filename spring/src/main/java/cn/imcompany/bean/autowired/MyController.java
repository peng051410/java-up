/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.bean.autowired;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author tomyli
 * @date 2025/6/5
 * enjoy
 */
@Controller
public class MyController {

    @Value("${USER}")
    @Getter
    private String username;

    @Getter
    @Value("student111")
    private StudentValue studentValue;

    @Autowired
    MyService myService;

    public void showService() {
        System.out.println("myService = " + myService);
    }
}
