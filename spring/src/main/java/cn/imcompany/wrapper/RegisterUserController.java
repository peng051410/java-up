/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.wrapper;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author tomyli
 * @date 2024/12/23
 * enjoy
 */
@Controller
public class RegisterUserController {

    private final PropertyEditorRegistrar customPropertyEditorRegistrar;

    public RegisterUserController(PropertyEditorRegistrar customPropertyEditorRegistrar) {
        this.customPropertyEditorRegistrar = customPropertyEditorRegistrar;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        customPropertyEditorRegistrar.registerCustomEditors(dataBinder);
    }
}
