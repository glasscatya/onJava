package com.glasscat.reflection;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("执行了某个动作");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("注意：" + arg);
    }
}

class SimpleProxy implements Interface {
    public Interface proxyInter;


    public SimpleProxy(Interface proxyInter) {
        this.proxyInter = proxyInter;
    }

    @Override
    public void doSomething() {
        System.out.println("代理执行额外操作");
        proxyInter.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("代理执行额外操作，在Else中");
        proxyInter.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("test");
    }


    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("-------------");
        consumer(new SimpleProxy(new RealObject()));
    }
}
