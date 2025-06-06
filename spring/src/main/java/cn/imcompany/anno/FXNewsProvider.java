/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.anno;

import cn.imcompany.IFXNewsListener;
import cn.imcompany.INewsPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author tomyli
 * @date 2024/11/19
 * enjoy
 */
@Component
public class FXNewsProvider {

    @Resource
    private IFXNewsListener newsListener;

    @Autowired
    private INewsPersister newsPersister;

    public void getAndPersistNews() {
        System.out.println(newsListener);
        newsListener.doJob();
        System.out.println(newsPersister);
    }
}
