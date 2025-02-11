/*
 * Copyright (c) 2025, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.webmvc;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @author tomyli
 * @date 2025/2/6
 * enjoy
 */
@Controller
@RequestMapping("/pets")
public class EditPetForm {

    @GetMapping
    public String setupForm(@RequestParam("petId") int petId, Model model) {
        return "petForm";
    }

    @PostMapping(path = "/process", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String processSubmit(@RequestParam MultiValueMap<String, String> params) {
        return "petForm process";
    }

    @PostMapping(path = "/optional")
    public String testOptional(@RequestParam Optional<String> name) {
        return name.orElse("no name");
    }

    /**
     * Host                    localhost:8080
     * Accept                  text/html,application/xhtml+xml,application/xml;q=0.9
     * Accept-Language         fr,en-gb;q=0.7,en;q=0.3
     * Accept-Encoding         gzip,deflate
     * Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7
     * Keep-Alive              300
     *
     * @param encoding
     * @param keepAlive
     */
    @GetMapping("/demo")
    public void handle(
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("Keep-Alive") long keepAlive) {
    }

    @GetMapping("/demo")
    public void handleHeaderComma(@RequestHeader("Accept") String encoding) {
    }

    @GetMapping("/demo")
    public void handleHeaderComma(@RequestHeader("Accept") String[] encoding) {
    }

    @GetMapping("/demo")
    public void handleHeaderComma(@RequestHeader("Accept") List<String> encoding) {
    }

    @GetMapping("/demo")
    public ResponseEntity<String> handle() {
        String etag = "123456";
        String body = "hello";
        return ResponseEntity.ok().eTag(etag).body(body);
    }
}
