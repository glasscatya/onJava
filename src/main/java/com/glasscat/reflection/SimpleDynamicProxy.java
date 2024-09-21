package com.glasscat.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass()
                + ", method: " + method
                + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);

        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    private static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("test");
    }

    public static void main(String[] args) {
        //本体与外界交流
        RealObject realObj = new RealObject();
        consumer(realObj);
        //使用动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class },
                new DynamicProxyHandler(realObj)
        );

        proxy.doSomething();
        proxy.somethingElse("test");

    }
}
