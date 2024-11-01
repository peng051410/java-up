/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.study.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tomyli
 * @date 2024/9/30
 * enjoy
 */
@RestController
@RequestMapping
@Slf4j
public class StudyController {

    @RequestMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

}
