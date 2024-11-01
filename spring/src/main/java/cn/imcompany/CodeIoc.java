/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author tomyli
 * @date 2024/10/30
 * enjoy
 */
public class CodeIoc {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanFactory);
        container.getBean("newsProvider", FXNewsProviderV2.class).getAndPersistNews();

        System.out.println("Start to test bindViaCodeSet->->->");
        container = bindViaCodeSet(beanFactory);
        container.getBean("newsProvider", FXNewsProviderV2.class).getAndPersistNews();
    }

    private static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {

        AbstractBeanDefinition newProvider = new RootBeanDefinition(FXNewsProviderV2.class);
        AbstractBeanDefinition newListener = new RootBeanDefinition(DowJonesNewsListenerV2.class);
        AbstractBeanDefinition newPersister = new RootBeanDefinition(DowJonesNewsPersisterV2.class);

        registry.registerBeanDefinition("newsProvider", newProvider);
        registry.registerBeanDefinition("newsListener", newListener);
        registry.registerBeanDefinition("newsPersister", newPersister);

        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newListener);
        argValues.addIndexedArgumentValue(1, newPersister);
        newProvider.setConstructorArgumentValues(argValues);

        return (BeanFactory) registry;
    }

    private static BeanFactory bindViaCodeSet(BeanDefinitionRegistry registry) {

        AbstractBeanDefinition newProvider = new RootBeanDefinition(FXNewsProviderV2.class);
        AbstractBeanDefinition newListener = new RootBeanDefinition(DowJonesNewsListenerV2.class);
        AbstractBeanDefinition newPersister = new RootBeanDefinition(DowJonesNewsPersisterV2.class);

        registry.registerBeanDefinition("newsProvider", newProvider);
        registry.registerBeanDefinition("newsListener", newListener);
        registry.registerBeanDefinition("newsPersister", newPersister);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newPersister));
        newProvider.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }
}
