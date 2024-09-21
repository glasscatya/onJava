package com.glasscat.reflection;

import com.glasscat.reflection.interfacea.A;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class AnonymousA {
    public static A makeA() {
        return new A() {
            private String secret = "这是一串秘密字符串";
            private int age = 1000;
            @Override
            public void f() {
                System.out.println("在匿名内部类中");
            }

            private void p() {
                System.out.println("匿名内部类的私有方法p()");
            }
        };
    }
}

public class AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        //a不能调用私有方法p
        //a.p()

        //a.secret 无法调出

        //但是通过反射可以
        HiddenImplementation.callHiddenMethod(a, "p");
        //通过反射可以拿到私有y字段
        Field f = a.getClass().getDeclaredField("secret");
        f.setAccessible(true);
        System.out.println(f.get(a));
        f.set(a, "字符串被读取");
        System.out.println(f.get(a));
    }
}
