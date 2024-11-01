/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany;

/**
 * @author tomyli
 * @date 2024/8/30
 * enjoy
 */
public class FXNewsProvider {

    private DowJonesNewsListener newsListener;
    private DowJonesNewsPersister newsPersister;

    public FXNewsProvider() {
    }

    public FXNewsProvider(DowJonesNewsListener newsListener, DowJonesNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void setNewsListener(DowJonesNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public void setNewsPersister(DowJonesNewsPersister newsPersister) {
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews() {
        System.out.println("getAndPersistNews");
        System.out.println("newsListener = " + newsListener);
        System.out.println("newsPersister = " + newsPersister);
    }
}
