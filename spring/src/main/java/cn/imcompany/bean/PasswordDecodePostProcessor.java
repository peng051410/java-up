package cn.imcompany.bean;

import cn.imcompany.PasswordDecodable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/24
 */
@Component
public class PasswordDecodePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PasswordDecodable) {
            final String password = ((PasswordDecodable) bean).getEncodePassword();
            String decodePassword = decodePassword(password);
            ((PasswordDecodable) bean).setDecodePassword(decodePassword);
        }
        return bean;
    }

    private String decodePassword(String password) {
        return "12345";
    }
}
