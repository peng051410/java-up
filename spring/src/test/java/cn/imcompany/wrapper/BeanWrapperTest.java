/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.wrapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * @author tomyli
 * @date 2024/12/23
 * enjoy
 */
class BeanWrapperTest {

    @Test
    public void testBasic() {

        BeanWrapperImpl company = new BeanWrapperImpl((new Company()));
        company.setPropertyValue("name", "Some Company Inc.");

        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);

        BeanWrapperImpl managingDirector = new BeanWrapperImpl(new Employee());
        managingDirector.setPropertyValue("name", "tomyli");

        company.setPropertyValue("managingDirector", managingDirector.getWrappedInstance());

        Assertions.assertEquals("tomyli", company.getPropertyValue("managingDirector.name"));
    }

}
