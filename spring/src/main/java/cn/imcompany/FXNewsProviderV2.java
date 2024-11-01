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
public class FXNewsProviderV2 {

    private IFXNewsListener newsListener;
    private INewsPersister newsPersister;

    public FXNewsProviderV2() {
    }

    public FXNewsProviderV2(IFXNewsListener newsListener, INewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    public FXNewsProviderV2 setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
        return this;
    }

    public INewsPersister getNewsPersister() {
        return newsPersister;
    }

    public FXNewsProviderV2 setNewsPersister(INewsPersister newsPersister) {
        this.newsPersister = newsPersister;
        return this;
    }

    public void getAndPersistNews() {
        System.out.println("getAndPersistNews");
        System.out.println("newsListener");
        newsListener.doJob();
        System.out.println("newsPersister = " + newsPersister);
    }

    public static void main(String[] args) {
        FXNewsProviderV2 fxNewsProviderV2 = new FXNewsProviderV2(new DowJonesNewsListenerV2(), new DowJonesNewsPersisterV2());
        FXNewsProviderV2 marketWin24Provider = new FXNewsProviderV2(new MarketWin24NewsListener(), new MarketWin24NewsPersister());
    }
}
