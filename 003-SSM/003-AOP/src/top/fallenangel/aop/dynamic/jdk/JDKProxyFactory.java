package top.fallenangel.aop.dynamic.jdk;

import java.lang.reflect.Proxy;

public class JDKProxyFactory {
    public interface ProxyNotice {
        void before();

        void after();
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<?> proxyClass, Class<T> agentClass, ProxyNotice proxyNotice) {
        return (T) Proxy.newProxyInstance(JDKProxyFactory.class.getClassLoader(), new Class[]{proxyClass}, (proxy, method, args) -> {
            T obj = agentClass.getConstructor().newInstance();
            proxyNotice.before();
            obj = (T) method.invoke(obj, args);
            proxyNotice.after();
            return obj;
        });
    }
}