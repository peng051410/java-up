package cn.imcompany.factory;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Todo：写点注释吧
 * <p>
 * Since:
 * Author: lizhipeng
 * Date: 2024/11/21
 */
public class FXNewsProviderMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
        System.out.println("before executing method[" + method.getName() + "] on object [" + target.getClass().getName());

        System.out.println("sorry,We will do nothing this time.");

        System.out.println("end of executing method[" + method.getName() + "] on object [" + target.getClass().getName());
        return null;
    }
}
