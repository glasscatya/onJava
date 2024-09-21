package com.glasscat.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")) {
            System.out.println("该方法已被代理!");
        }
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boring1();

    void boring2();

    void interesting(String string);
}

class Implementation implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String string) {
        System.out.println(string);
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods realImp = new Implementation();
        realImp.boring1();
        realImp.boring2();
        realImp.interesting("这是一个测试。");
        System.out.println("---------------");
        //这里也可以直接使用 Object proxyImp 就可以应对类实现了多个接口的情况，在调用时再强转对应的接口。
        SomeMethods proxyImp = (SomeMethods) Proxy.newProxyInstance(
                Implementation.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(realImp));

        proxyImp.boring2();
        proxyImp.boring1();
        proxyImp.interesting("这也是一个测试。");
    }
}
