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
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author tomyli
 * @date 2024/8/30
 * enjoy
 */
public class SpringFactory {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();

        BeanFactory container = bindViaCode(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newsProvider");
        newsProvider.getAndPersistNews();

        System.out.println("====================================");
        loadWithXml(beanRegistry);
        System.out.println("====================================");
        loadWithXmlByFactory(beanRegistry);
    }

    private static void loadWithXmlByFactory(DefaultListableBeanFactory beanRegistry) {
        BeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-config-factory.xml"));
        FXNewsProviderV2 newsProvider = xmlBeanFactory.getBean("fxNewsProvider", FXNewsProviderV2.class);
        newsProvider.getAndPersistNews();
    }

    private static void loadWithXml(DefaultListableBeanFactory beanRegistry) {

        new XmlBeanDefinitionReader(beanRegistry).loadBeanDefinitions("spring-config.xml");
        ((BeanFactory) beanRegistry).getBean("fxNewsProvider", FXNewsProviderV2.class).getAndPersistNews();
    }

    private static BeanFactory bindViaCode(DefaultListableBeanFactory registry) {

        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

        registry.registerBeanDefinition("newsProvider", newsProvider);
        registry.registerBeanDefinition("newsListener", newsListener);
        registry.registerBeanDefinition("newsPersister", newsPersister);

        //bind with constructor
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newsListener);
        argValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);

        //bind with setter method
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        return registry;
    }

    public static void getRegistryWithLoader() {
        BeanDefinitionRegistry beanRegistry = new DefaultListableBeanFactory();
        new XmlBeanDefinitionReader(beanRegistry).loadBeanDefinitions("hello.xml");
    }
}
