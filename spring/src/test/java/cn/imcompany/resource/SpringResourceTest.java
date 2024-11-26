/*
 * Copyright (c) 2024, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.imcompany.resource;

import org.junit.jupiter.api.Test;
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

}
