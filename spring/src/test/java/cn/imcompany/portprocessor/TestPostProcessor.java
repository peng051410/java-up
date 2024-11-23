package cn.imcompany.portprocessor;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/23
 */
public class TestPostProcessor {

    @Test
    public void testPostProcessor() {
        final ConfigurableListableBeanFactory context = new XmlBeanFactory(new ClassPathResource(""));
        final PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocations();
        placeholderConfigurer.postProcessBeanFactory(context);
    }

    @Test
    public void testPostProcessorWithContext() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring-post-processor.xml");
        final BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        Assertions.assertEquals("localhost", dataSource.getUrl());
        Assertions.assertEquals(200, dataSource.getMaxTotal());
    }
}
