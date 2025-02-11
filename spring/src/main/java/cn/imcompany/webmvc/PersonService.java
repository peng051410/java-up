/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author tomyli
 * @date 2025/2/5
 * enjoy
 */
@HttpExchange("/persons")
public interface PersonService {

    @GetExchange("/{id}")
    Person getPerson(String id);

    @PostExchange
    void add(@RequestBody Person person);
}
