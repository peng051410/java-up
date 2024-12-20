/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.binding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;

/**
 * @author tomyli
 * @date 2024/12/20
 * enjoy
 */
class ValidatorTest {

    @Test
    public void testBasic() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.binding");
        CustomerValidator bean = context.getBean(CustomerValidator.class);
        Customer target = new Customer();
        target.setFisrtName("Tom");
        target.setSurName("Li");
        Address address = new Address();
        address.setName("Tom");
        address.setStreet("Li");
        target.setAddress(address);
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(target, "customer");
        bean.validate(target, result);
        Assertions.assertEquals(0, result.getFieldErrors().size());
    }

    @Test
    public void testBasic_valid_error() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.binding");
        CustomerValidator bean = context.getBean(CustomerValidator.class);
        Customer target = new Customer();
        target.setFisrtName("Tom");
        target.setSurName("Li");
        Address address = new Address();
        address.setName("T");
        address.setStreet("Li");
        target.setAddress(address);
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(target, "customer");
        bean.validate(target, result);
        Assertions.assertEquals(1, result.getFieldErrors().size());
    }

}
