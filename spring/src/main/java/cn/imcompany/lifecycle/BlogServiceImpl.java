/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author tomyli
 * @date 2024/12/4
 * enjoy
 */
public class BlogServiceImpl implements BlogService, BeanNameAware {

    private BlogDao blogDao;

    public void setBlogDao(BlogDao blogDao) {
        System.out.println("set blog dao");
        this.blogDao = blogDao;
    }

    public void init() {
        System.out.println(this.getClass() + " init");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is " + name);
    }
}
