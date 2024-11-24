package cn.imcompany.bean;

import cn.imcompany.FXNewsProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/24
 */
public class TestBeanWrapper {

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
}
