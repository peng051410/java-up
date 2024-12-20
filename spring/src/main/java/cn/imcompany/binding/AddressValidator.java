/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.binding;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author tomyli
 * @date 2024/12/20
 * enjoy
 */
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Address address = (Address) target;
        if (address.getName() == null || address.getName().length() < 2) {
            errors.rejectValue("name", "name.min.length", "name is too short");
        }

        if (address.getStreet() == null || address.getStreet().length() < 2) {
            errors.rejectValue("street", "street.min.length", "street is too short");
        }
    }
}
