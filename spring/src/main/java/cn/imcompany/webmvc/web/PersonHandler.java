/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc.web;

import cn.imcompany.webmvc.Person;
import jakarta.servlet.ServletException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author tomyli
 * @date 2025/2/8
 * enjoy
 */
public class PersonHandler {

    // ...

    public ServerResponse listPeople(ServerRequest request) throws ServletException, IOException {
        String body = request.body(String.class);
        List<Person> people = request.body(new ParameterizedTypeReference<>() {
        });
        MultiValueMap<String, String> params = request.params();
        // ...

        Person person = new Person();
        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(person);

        return null;
    }

    public ServerResponse createPerson(ServerRequest request) {
        // ...
        return null;
    }

    public ServerResponse getPerson(ServerRequest request) {

        // ...
        return null;
    }
}
