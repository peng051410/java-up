package cn.imcompany.bean;

import cn.imcompany.FXNewsProvider;
import cn.imcompany.anno.DowJonesNewsListenerV2Anno;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/24
 */
public class TestBeanCreate {
    @Test
    public void testWrapper() throws Exception {
        final Object newsProvider = Class.forName("cn.imcompany.FXNewsProvider").newInstance();
        final Object newsListener = Class.forName("cn.imcompany.DowJonesNewsListener").newInstance();
        final Object newsPersister = Class.forName("cn.imcompany.DowJonesNewsPersister").newInstance();

        final BeanWrapper beanWrapper = new BeanWrapperImpl(newsProvider);
        beanWrapper.setPropertyValue("newsListener", newsListener);
        beanWrapper.setPropertyValue("newsPersister", newsPersister);

        assertTrue(beanWrapper.getWrappedInstance() instanceof FXNewsProvider);
        assertSame(newsProvider, beanWrapper.getWrappedInstance());
        assertSame(newsListener, beanWrapper.getPropertyValue("newsListener"));
        assertSame(newsPersister, beanWrapper.getPropertyValue("newsPersister"));
    }

    @Test
    public void testBeanProcessor() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany");
        final DowJonesNewsListenerV2Anno bean = context.getBean(DowJonesNewsListenerV2Anno.class);
        assertEquals("12345", bean.getEncodePassword());
    }

    @Test
    public void testBeanConstructor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        ExampleBean myBean = context.getBean("myBean", ExampleBean.class);
        System.out.println(myBean);

        TargetBean targetBean = context.getBean("targetBean", TargetBean.class);
        System.out.println(targetBean.getExampleBean());

    }

    @Test
    public void testBeanPNameSpace() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-p.xml");
        BasicDataSource myBean = context.getBean("myBean", BasicDataSource.class);
        System.out.println(myBean.getUrl());
    }

    @Test
    public void testBeanProperties() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-properties.xml");
        BasicDataSource dataSource = context.getBean("dataSource", BasicDataSource.class);
        System.out.println(dataSource.getUrl());
    }

    @Test
    public void testBeanMerge() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-parent.xml");
        ParentObject parentObject = context.getBean("child", ParentObject.class);
        parentObject.getAdminEmails().forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Test
    public void testMapGeneric() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-generic.xml");
        SomeClass someClass = context.getBean(SomeClass.class);
        someClass.getAccounts().forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Test
    public void testSingleDepedenOnPrototype() {
        // 这种实现耦合度太高，不推荐
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config-single-prototype.xml");
        context.getBean("commandManager", CommandManager.class).process(null);
        context.getBean("commandManager", CommandManager.class).process(null);
    }

    @Test
    public void testSingleDepedenOnPrototypeWithLookUp() {
        // 推荐使用lookup-method
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config-single-prototype.xml");
        context.getBean("commandManagerV2", CommandManagerV2.class).process(null);
        context.getBean("commandManagerV2", CommandManagerV2.class).process(null);
    }

    @Test
    public void testSingleDepedenOnPrototypeWithLookUpAnno() {
        // 推荐使用lookup-method
        ApplicationContext context = new AnnotationConfigApplicationContext("cn.imcompany.bean");
        context.getBean(CommandManagerAnno.class).process(null);
        context.getBean(CommandManagerAnno.class).process(null);
    }
}

