package cn.imcompany.bean;

import cn.imcompany.FXNewsProvider;
import cn.imcompany.anno.DowJonesNewsListenerV2Anno;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

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
}
