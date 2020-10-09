package top.fallenangel.aop.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CGLibProxyFactory {
    public interface ProxyNotice {
        void before();

        void after();
    }

    public static <T> T createProxy(Class<T> agent, ProxyNotice proxyNotice) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(agent);
        enhancer.setCallback((MethodInterceptor) (object, method, params, proxy) -> {
            proxyNotice.before();
            Object result = proxy.invokeSuper(object, params);
            proxyNotice.after();
            return result;
        });
        return (T) enhancer.create();
    }
}