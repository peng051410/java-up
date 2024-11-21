package cn.imcompany.factory;

import cn.imcompany.INewsPersister;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/21
 */
public class MockNewsWithAwarePersister implements INewsPersister, BeanFactoryAware {

    private BeanFactory beanFactory;

    public void persistNews() {
        System.out.println("persist bean: " + getFxNewsBean());
    }

    public FXNewsBean getFxNewsBean() {
        return beanFactory.getBean(FXNewsBean.class);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
