package co.ivi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.DefaultMethodCall;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.Pipe;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.isAnnotatedWith;
import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.takesArguments;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {

        new App().testToString();
        new App().methodMatch();
        new App().testDelegate();
        new App().testSupperCall();
        new App().testSupper();
        new App().testRuntimeType();
        new App().testPipe();
        new App().testCallDefaultMethod();

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

        // 创建一个新类，并加载到当前 ClassLoader
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .make()
                .load(App.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        // redefine Foo to Bar
        ByteBuddyAgent.install();
        Foo foo = new Foo();
        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        System.out.println(foo.m().equals("bar"));

        // redefine use TypeDescription
        // TypePool typePool = TypePool.Default.ofSystemLoader();
        // Class<?> bar = new ByteBuddy()
        //         .redefine(typePool.describe("foo.Bar").resolve(),  // do not use Bar.class
        //                 ClassFileLocator.ForClassLoader.ofSystemLoader())
        //         .defineField("qux", String.class)
        //         .make()
        //         .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION)
        //         .getLoaded();
        // System.out.println(bar.getDeclaredField("qux"));


    }

    private void testCallDefaultMethod() throws InstantiationException, IllegalAccessException {
        Object qux1 = new ByteBuddy(ClassFileVersion.JAVA_V8)
                .subclass(Object.class)
                .implement(First.class)
                .implement(Second.class)
                .method(named("qux")).intercept(DefaultMethodCall.prioritize(First.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(qux1 instanceof First);
        System.out.println(qux1 instanceof Second);
        System.out.println(((First) qux1).qux());
    }

    private void testPipe() throws InstantiationException, IllegalAccessException {
        MemoryDatabase memoryDatabase = new ByteBuddy()
                .subclass(MemoryDatabase.class)
                .method(named("load")).intercept(MethodDelegation.withDefaultConfiguration()
                        .withBinders(Pipe.Binder.install(Forwarder.class))
                        .to(new ForwardingLoggerInterceptor(new MemoryDatabase())))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(memoryDatabase.load("qux"));
    }

    private void testRuntimeType() throws InstantiationException, IllegalAccessException {

        Loop loop = new ByteBuddy()
                .subclass(Loop.class)
                .method(named("loop")).intercept(MethodDelegation.to(LoopInterceptor.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(loop.loop("Hello"));
        System.out.println(loop.loop(10));
    }

    public void testToString() throws InstantiationException, IllegalAccessException {
        String toString = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .toString();
        System.out.println(toString);
    }

    public void overrideToString() throws InstantiationException, IllegalAccessException {
        String toString = new ByteBuddy()
                .subclass(Object.class)
                .name("example.Type")
                .method(named("toString")).intercept(FixedValue.value("Hello World!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .toString();
        System.out.println(toString);
    }

    public void methodMatch() throws InstantiationException, IllegalAccessException {
        Three three = new ByteBuddy()
                .subclass(Three.class)
                .method(isDeclaredBy(Three.class)).intercept(FixedValue.value("One!"))
                .method(named("foo")).intercept(FixedValue.value("Two!"))
                .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(three.bar().equals("One!"));
        System.out.println(three.foo().equals("Two!"));
        System.out.println(three.foo(new Object()).equals("Three!"));
    }

    public void testDelegate() throws InstantiationException, IllegalAccessException {
        String hello = new ByteBuddy()
                .subclass(Source.class)
                .method(named("hello")).intercept(MethodDelegation.to(Target.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .hello("World");
        System.out.println(hello);
    }

    public void testSupperCall() throws InstantiationException, IllegalAccessException {
        MemoryDatabase loggingDatabase = new ByteBuddy()
                .subclass(MemoryDatabase.class)
                .method(named("load")).intercept(MethodDelegation.to(LoggerInterceptor.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(loggingDatabase.load("qux"));
    }

    public void testSupper() throws InstantiationException, IllegalAccessException {
        MemoryDatabase loggingDatabase = new ByteBuddy()
                .subclass(MemoryDatabase.class)
                .method(named("load")).intercept(MethodDelegation.to(ChangingLoggerInterceptor.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(loggingDatabase.load("qux"));
    }

    public static void premain(String arg, Instrumentation instrumentation) {

        new AgentBuilder.Default()
                .type(isAnnotatedWith(ToString.class))
                .transform((builder, typeDescription, classLoader, javaModule, protectionDomain) -> builder.method(named("toString"))
                        .intercept(FixedValue.value("transformed"))).installOn(instrumentation);
    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface ToString {

}
