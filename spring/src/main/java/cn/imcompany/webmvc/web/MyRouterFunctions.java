/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;

/**
 * @author tomyli
 * @date 2025/2/8
 * enjoy
 */
@Configuration
public class MyRouterFunctions {

    @Bean
    public RouterFunction<?> routerFunction() {
        PersonHandler handler = new PersonHandler();

        // router functions provide not just data, but also behavior.
        return route()
                .GET("/person/{id}", accept(APPLICATION_JSON), handler::getPerson)
                .GET("/person", accept(APPLICATION_JSON), handler::listPeople)
                .POST("/person", handler::createPerson)
                .build();
    }
}
