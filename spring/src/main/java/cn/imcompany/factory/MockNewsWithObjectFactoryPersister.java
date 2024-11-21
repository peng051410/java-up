package cn.imcompany.factory;

import cn.imcompany.INewsPersister;
import org.springframework.beans.factory.ObjectFactory;


/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/21
 */
public class MockNewsWithObjectFactoryPersister implements INewsPersister {

    private ObjectFactory<FXNewsBean> objectFactory;

    public void persistNews(FXNewsBean fxNewsBean) {
        persistNews();
    }

    public void persistNews() {
        System.out.println("persist bean: " + getFxNewsBean());
    }

    public FXNewsBean getFxNewsBean() {
        return objectFactory.getObject();
    }

    public MockNewsWithObjectFactoryPersister setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
        return this;
    }

}
