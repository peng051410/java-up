/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author tomyli
 * @date 2024/12/31
 * enjoy
 */
public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Foo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        System.out.println(target);
        Foo target1 = (Foo) target;
        if (target1.getName() == null) {
            errors.rejectValue("name", "name.required");
        } else if (target1.getName().length() > 10) {
            errors.rejectValue("name", "name.too.long");
        }
    }
}
