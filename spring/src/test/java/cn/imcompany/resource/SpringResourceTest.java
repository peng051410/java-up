/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author tomyli
 * @date 2024/11/25
 * enjoy
 */
class SpringResourceTest {

    @Test
    public void testResourceLoader() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("D:/tmp/aa.txt");
        assertInstanceOf(ClassPathResource.class, resource);
        assertFalse(resource.exists());

        Resource resource1 = resourceLoader.getResource("file:/tmp/aa.txt");
        assertInstanceOf(UrlResource.class, resource1);

        Resource resource2 = resourceLoader.getResource("http://www.baidu.com");
        assertInstanceOf(UrlResource.class, resource2);

        try {
            resource.getFile();
            fail("no such file with this path[\"file:/tmp/aa.txt\"]" + resource.getFilename());
        } catch (IOException e) {
            // expected
        }

        try {
            resource1.getFile();
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void testFileSystemResourceLoader() {
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource("D:/tmp/aa.txt");
        assertInstanceOf(FileSystemResource.class, resource);
        assertFalse(resource.exists());

        Resource urlResource = resourceLoader.getResource("file:/tmp/aa.txt");
        assertInstanceOf(UrlResource.class, urlResource);
    }

    @Test
    public void testMultiResourceLoaderGetSingleResource() {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("D:/tmp/aa.txt");
        assertInstanceOf(ClassPathResource.class, resource);
    }

    //testMultiResourceLoaderChangePatternResolver
    @Test
    public void testMultiResourceLoaderChangePatternResolver() {
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        Resource resource = patternResolver.getResource("D:/tmp/aa.txt");
        assertInstanceOf(FileSystemResource.class, resource);
    }

    @Test
    public void testApplicationContextAsResourceLoader() {
        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("spring-config.xml");
        Resource resource = resourceLoader.getResource("D:/tmp/aa.txt");
        assertInstanceOf(ClassPathResource.class, resource);
        assertFalse(resource.exists());

        Resource resource1 = resourceLoader.getResource("http://www.baidu.com");
        assertInstanceOf(UrlResource.class, resource1);
    }

    @Test
    public void testBeanAwareUseResourceLoader() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("cn.imcompany.resource");
        applicationContext.getBean(FooBar.class).foo("D:/tmp/aa.txt");
        applicationContext.getBean(FooBar2.class).foo("D:/tmp/aa.txt");
    }

    @Test
    public void testSpringResource() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-resource.xml");
        XMailer bean = context.getBean(XMailer.class);
        bean.sendMail();
    }

    @Test
    public void testSpringClassPathPrefix() {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-resource.xml");
        Resource resource = context.getResource("D:/tmp/aa.txt");
        assertInstanceOf(FileSystemResource.class, resource);

        context.getBean(XMailer.class).sendMail();
    }

    @Test
    public void testFileSystemApplicationContext() {

        assertThrows(BeanDefinitionStoreException.class, () -> {
            // file not exist
            ApplicationContext context = new FileSystemXmlApplicationContext("/tmp/spring-resource.xml");
        });
    }

}
