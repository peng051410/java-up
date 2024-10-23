package co.ivi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(Object.class) // 定义一个继承自Object的类
                .make();

        DynamicType.Unloaded<?> dynamicType1 = new ByteBuddy()
                .subclass(Object.class) // 定义一个继承自Object的类
                .name("cn.imcompany.MyDynamicType") // 设置类名，不提供则使用 NamingStrategy 对类名进行生成
                .make();

        DynamicType.Unloaded<?> dynamicType2 = new ByteBuddy()
                .with(new NamingStrategy.AbstractBase() { // 自定义类名生成策略，使用时小心命名冲突
                    @Override
                    protected String name(TypeDescription superClass) {
                        return "i.love.ByteBuddy." + superClass.getSimpleName();
                    }
                })
                .subclass(Object.class) // 定义一个继承自Object的类
                .make();
    }
}
