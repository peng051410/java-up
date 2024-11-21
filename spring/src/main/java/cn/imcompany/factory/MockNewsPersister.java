package cn.imcompany.factory;

import cn.imcompany.INewsPersister;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/21
 */
public class MockNewsPersister implements INewsPersister {

    private FXNewsBean fxNewsBean;

    public void persistNews(FXNewsBean fxNewsBean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean: " + getFxNewsBean());
    }

    public FXNewsBean getFxNewsBean() {
        return fxNewsBean;
    }

    public MockNewsPersister setFxNewsBean(FXNewsBean fxNewsBean) {
        this.fxNewsBean = fxNewsBean;
        return this;
    }
}
