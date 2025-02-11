/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tomyli
 * @date 2025/2/5
 * enjoy
 */
@RestController
public class PersonController implements PersonService {

    @Override
    public Person getPerson(@PathVariable String id) {
        return new Person();
    }

    @Override
    public void add(@RequestBody Person person) {
        // implementation omitted
    }
}
